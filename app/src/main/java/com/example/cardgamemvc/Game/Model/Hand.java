package com.example.cardgamemvc.Game.Model;

import java.util.List;

/**
 * Ensemble de cartes détenues par un joueur
 */
public class Hand {

    private List<PlayingCard> aCards;


    public void addCard(PlayingCard oCardP){
        aCards.add(oCardP);
    }

    public PlayingCard removeCard(){
       return aCards.remove(0);
    }

    public PlayingCard getCard(int nIndexP){
        return aCards.get(nIndexP);
    }

}
