package com.example.cardgamemvc.model;

/**
 * One card
 */
public class PlayingCard {

    private Rank oRank;
    private Suit oSuit;
    private boolean bFaceUp;

    public PlayingCard(Rank rank, Suit suit) {
        super();
        this.oRank = rank;
        this.oSuit = suit;
    }
    public Rank getRank() {
        return oRank;
    }
    public Suit getSuit() {
        return oSuit;
    }

    public boolean isFaceUp() {
        return bFaceUp;
    }

    public boolean flip() {
        bFaceUp = !bFaceUp;
        return bFaceUp;
    }

}
