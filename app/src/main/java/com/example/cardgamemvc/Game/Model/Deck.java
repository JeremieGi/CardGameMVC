package com.example.cardgamemvc.Game.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Tas de carte
 */
public abstract class Deck {

    protected final List<PlayingCard> aCards = new ArrayList<PlayingCard>();



    /**
     * Mélange le jeu
     */
    public void shuffle() {

        // Objet random qui va permettre d'avoir un entier aléatoire entre 0 et 51
        Random random = new Random();

        for (int i = 0; i < aCards.size(); i++){
            int nRandom = random.nextInt(aCards.size()-1);
            Collections.swap(aCards,i,nRandom);
        }
    }

    /**
     * Tire la première carte du paquet
     * @return : première carte du paquet
     */
    public PlayingCard removeTopCard(){
        return aCards.remove(0);
    }

    /**
     * Remet la carte dans le paquet
     * @param : Carte retournée
     */
    public void returnCardToDeck(PlayingCard oCardP){
        aCards.add(oCardP);
    }



}
