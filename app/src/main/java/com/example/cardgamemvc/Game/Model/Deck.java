package com.example.cardgamemvc.Game.Model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<PlayingCard> aCards;

    public Deck(){

        // Crée toutes les cartes
        for (Rank r : Rank.values()){
            for (Suit s : Suit.values()){
                PlayingCard oCard = new PlayingCard(r,s);
                aCards.add(oCard);
            }
        }

        // Mélange
        shuffle();

    }


    // ------- GETTER --------------------
    public List<PlayingCard> getaCards() {
        return aCards;
    }



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
     * @return
     */
    public PlayingCard removeTopCard(){
        return aCards.remove(0);
    }

    /**
     * Remet la carte dans le paquet
     * @param oCardP
     */
    public void returnCardToDeck(PlayingCard oCardP){
        aCards.add(oCardP);
    }



}
