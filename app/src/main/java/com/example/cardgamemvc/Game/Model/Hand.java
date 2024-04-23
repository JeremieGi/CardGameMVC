package com.example.cardgamemvc.Game.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Ensemble de cartes détenues par un joueur
 */
public class Hand {

    private final List<PlayingCard> aCards;

    public Hand() {
        this.aCards = new ArrayList<>();
    }

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
