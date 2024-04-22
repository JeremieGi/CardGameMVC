package com.example.cardgamemvc.Game.Evaluators;

import com.example.cardgamemvc.Game.Model.Player;
import com.example.cardgamemvc.Game.Model.PlayingCard;

import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator {
    public Player evaluateWinner(List<Player> aPlayersP){

        Player bestPlayer = null;

        // Pour tous les joueurs
        for (Player p : aPlayersP){

            // Retourne la 1ere carte de leur main
            PlayingCard oPlayedCard = p.getCard(0);

            // Permier joueur analysé
            if (bestPlayer == null){
                bestPlayer = p;
            }
            else {
                PlayingCard oBestCard = bestPlayer.getCard(0);
                if (bIsBestCard(oPlayedCard,oBestCard)){
                    bestPlayer = p;
                }
            }

        }

        return bestPlayer;

    }

    /**
     * Renvoie Vrai si oPlayedCard est meilleure que oBestCard
     * @param oPlayedCard : Carte jouée
     * @param oBestCard : Meilleure carte du jeu
     * @return vrai si carte jouée plus forte que oBestCard
     */
    private boolean bIsBestCard(PlayingCard oPlayedCard, PlayingCard oBestCard) {

        // Carte de valeur différente
        if (oPlayedCard.getRank().value() != oBestCard.getRank().value()){
            return oPlayedCard.getRank().value() > oBestCard.getRank().value();
        }
        else{
            // Sinon valeur égale, prio par Suit
            return oPlayedCard.getSuit().value() > oBestCard.getSuit().value();
        }

    }

}
