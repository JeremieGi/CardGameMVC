package com.example.cardgamemvc.Game.Model;

public class SimpleDeck extends Deck{

    public SimpleDeck() {

        // Crée toutes les cartes
        for (Rank r : Rank.values()){
            if (r.value()>=7){
                for (Suit s : Suit.values()){
                    PlayingCard oCard = new PlayingCard(r,s);
                    aCards.add(oCard);
                }
            }
        }

        // Mélange
        shuffle();

    }
}
