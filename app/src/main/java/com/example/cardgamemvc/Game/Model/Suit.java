package com.example.cardgamemvc.Game.Model;

public enum Suit {

    DIAMONDS(1),
    HEARTS(2),
    SPADES(3),
    CLUBS(4);

    final int suit;

    private Suit(int value) {
        suit = value;
    }

    public int value() {
        return suit;
    }

}
