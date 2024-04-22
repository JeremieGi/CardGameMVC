package com.example.cardgamemvc.Game.Model;

public class NormalDeck extends Deck{

    public NormalDeck() {

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
}
