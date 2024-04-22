package com.example.cardgamemvc.Game.Controller;

import com.example.cardgamemvc.Game.Evaluators.GameEvaluator;
import com.example.cardgamemvc.Game.Model.Deck;
import com.example.cardgamemvc.Game.Model.Player;
import com.example.cardgamemvc.Game.Model.PlayingCard;
import com.example.cardgamemvc.Game.View.IGameViewable;

import java.util.ArrayList;
import java.util.List;

public class GameController {




    enum GameState {
        AddingsPlayers, CardsDealt, WinnerRevealed
    }

    // Echange avec la vue
    IGameViewable oView;

    // Echange avec le Model
    Deck oDeck;
    List<Player> aPlayers;
    Player oWinner;

    // Variables propres au controller

    GameState oGameState;

    GameEvaluator oEvaluator;

    public GameController(IGameViewable viewP, Deck deckP, GameEvaluator oEvaluatorP) {

        this.oView = viewP;
        this.oDeck = deckP;

        this.aPlayers = new ArrayList<Player>();

        oGameState = GameState.AddingsPlayers;

        this.oView.setController(this);

        this.oEvaluator = oEvaluatorP;
    }

    public void initPlayer() {
        aPlayers.clear();
    }
    /*
    public void run(){

        switch (oGameState) {

            // Cartes distribuées
            case CardsDealt:
                oView.showCardForPlayer();
                break;

            // Gagnant de la partie connu
            case WinnerRevealed:
                oView.showFaceDownCardForPlayer();
                break;

        }

    }
*/
    /**
     * Ajoute un joueur
     * @param sPlayerNameP : nom du joueur saisi dans l'UI
     */
    public void addPlayer (String sPlayerNameP){
        if (oGameState == GameState.AddingsPlayers) {
            Player p = new Player(sPlayerNameP);
            aPlayers.add(p);
            int nNbPlayer = aPlayers.size();
            oView.showPlayersNames(nNbPlayer,sPlayerNameP);
        }
    }

    /**
     * Démarre le jeu
     */
    public void startGame(){



        // Si les cartes ne sont pas distribuées
        if (oGameState != GameState.CardsDealt) {
            // Mélange le paquet
            oDeck.shuffle();

            int nIndexPlayer = 1;

            // Pour chaque joueur
            for (Player p : aPlayers){
                // Distribue une carte
                PlayingCard card = oDeck.removeTopCard();
                p.addCardToHand(card);
                //
                oView.showFaceDownCardForPlayer(nIndexPlayer, p.getsPlayerName());

                nIndexPlayer++;
            }
            // Etat = jeu distribué
            oGameState = GameState.CardsDealt;
        }
        //this.run();
    }

    /**
     * Retourne les cartes des joueurs
     */
    public void flipCards(){

        int nIndexPlayer = 1;

        // Pour tous les joueurs
        for (Player p : aPlayers){
            // Retourne la 1ere carte de leur main
            PlayingCard oCardFlipped = p.getCard(0);
            oCardFlipped.flip();
            oView.showCardForPlayer(nIndexPlayer, p.getsPlayerName(),oCardFlipped.getRank().toString(), oCardFlipped.getSuit().toString());

            nIndexPlayer++;
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();

        oGameState = GameState.WinnerRevealed; // Le gagnant est connu à cet instant

    }

    /**
     * Jouer le tour suivant
     */
    public void rebuildDeck() {
        // Pour tous les joueurs
        for (Player p : aPlayers){
            PlayingCard oCard = p.removeCard(); // Enlève la carte de la main du joueur
            oDeck.returnCardToDeck(oCard);      // La remet dans le paquet
        }
    }

    /**
     *
     */
    private void displayWinner() {
        oView.showWinner(oWinner.getsPlayerName());
    }




    /**
     * Détermine le gagnant
     */
    private void evaluateWinner() {

        // Les règles du jeu seront dans un autre classe qui aura uniquement ce role)
        oWinner = oEvaluator.evaluateWinner(aPlayers);

    }


}
