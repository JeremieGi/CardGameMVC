package com.example.cardgamemvc.Game.Controller;

import com.example.cardgamemvc.Game.Model.Deck;
import com.example.cardgamemvc.Game.Model.Player;
import com.example.cardgamemvc.Game.Model.PlayingCard;

import java.util.ArrayList;
import java.util.List;

class View {
    public void somethingEcranSaisieJoueur(){

    };

    public void setController(GameController gameControllerP){

    };

    public void somethingAfficheCarte() {

    }

    public void somethingAfficheGagnant() {
    }

    public void somethingCarteDistribueeAUnJoueur() {
    }

    public void somethingCarteRetournee() {
    }
}

public class GameController {


    public GameController(View viewP, Deck deckP) {

        this.oView = viewP;
        this.oDeck = deckP;

        this.aPlayers = new ArrayList<Player>();

        oGameState = GameState.AddingsPlayers;

        this.oView.setController(this);
    }

    enum GameState {
        AddingsPlayers, CardsDealt, WinnerRevealed;
    }

    // Echange avec la vue
    View oView;


    // Echange avec le Model
    Deck oDeck;
    List<Player> aPlayers;
    Player oWinner;

    // Variables propres au controller

    GameState oGameState;

    public void run(){

        while (oGameState == GameState.AddingsPlayers) {
            oView.somethingEcranSaisieJoueur();
        }

        switch (oGameState) {

            // Cartes distribuées
            case CardsDealt:
                oView.somethingAfficheCarte();
                break;

            case WinnerRevealed:
                oView.somethingAfficheGagnant();
                break;

        }

    }

    /**
     * Ajoute un joueur
     * @param sPlayerNameP : nom du joueur saisi dans l'UI
     */
    public void addPlayer (String sPlayerNameP){
        if (oGameState == GameState.AddingsPlayers) {
            Player p = new Player(sPlayerNameP);
            aPlayers.add(p);
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
            // Pour chaque joueur
            for (Player p : aPlayers){
                // Distribue une carte
                PlayingCard card = oDeck.removeTopCard();
                p.addCardToHand(card);
                //
                oView.somethingCarteDistribueeAUnJoueur();
            }
            // Etat = jeu distribué
            oGameState = GameState.CardsDealt;
        }
        this.run();
    }

    /**
     * Retourne les cartes des joueurs
     */
    public void flipCards(){

        // Pour tous les joueurs
        for (Player p : aPlayers){
            // Retourne la 1ere carte de leur main
            p.getCard(0).flip();
            oView.somethingCarteRetournee();
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();

        oGameState = GameState.WinnerRevealed; // ?????
        this.run();

    }

    private void rebuildDeck() {
    }

    private void displayWinner() {
        
    }

    private void evaluateWinner() {
        
    }
}
