package com.example.cardgamemvc.Game.Model;

/**
 * Utilisation d'un pattern Factory pour créer un jeu de 32 ou 52 cartes
 */
public class DeckFactory {

    public static Deck createDeck(EDeskType eDeskType) {

        switch (eDeskType) {
            case normal: return new NormalDeck();
            case small:  return new SimpleDeck();
        }

        return new NormalDeck();
    }

    public enum EDeskType {
        normal,
        small/*,
        test*/ // Pourrait être utile pour des TA par exemple
    }



}
