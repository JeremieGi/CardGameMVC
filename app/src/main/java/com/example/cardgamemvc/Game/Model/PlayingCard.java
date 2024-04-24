package com.example.cardgamemvc.Game.Model;

import com.example.cardgamemvc.R;

/**
 * One card
 */
public class PlayingCard {

    private final Rank  oRank;
    private final Suit oSuit;
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


    public void flip() {
        bFaceUp = !bFaceUp;
    }


    /**
     *
     * @return Nom de la ressource associée à la carte
     */
    public String sRessourceName() {

        // Je n'ai pas réussi à afficher côté UI une ressource à partir de son nom (getIdentifier)...
        // => j'ai du écrire oRessourceName

        String sRessourceName = "_"; // Toutes les images de cartes commencent par _

        String sValue = String.valueOf(oRank.value());

        switch (oRank){
            case JACK :
                sValue = "j";
                break;
            case QUEEN :
                sValue = "q";
                break;
            case KING :
                sValue = "k";
                break;
            case ACE :
                sValue = "a";
                break;
        }

        sRessourceName += sValue;

        switch (oSuit){
            case DIAMONDS  :
                sRessourceName += "d";
                break;
            case HEARTS :
                sRessourceName += "h";
                break;
            case SPADES :
                sRessourceName += "s";
                break;
            case CLUBS :
                sRessourceName += "c";
                break;
        }

        sRessourceName += ".gif";

        return sRessourceName;
    }

    public int oRessourceName() {

        int nIDRessource = 0;

        // Je n'ai pas réussi à afficher côté UI une ressource à partir de son nom (getIdentifier)...
        // => j'ai du écrire en dur...

        switch (oSuit){
            case DIAMONDS  :
                switch (oRank){
                    case TWO :
                        nIDRessource = R.drawable._2d;
                        break;
                    case THREE :
                        nIDRessource = R.drawable._3d;
                        break;
                    case FOUR :
                        nIDRessource = R.drawable._4d;
                        break;
                    case FIVE :
                        nIDRessource = R.drawable._5d;
                        break;
                    case SIX :
                        nIDRessource = R.drawable._6d;
                        break;
                    case SEVEN :
                        nIDRessource = R.drawable._7d;
                        break;
                    case EIGHT :
                        nIDRessource = R.drawable._8d;
                        break;
                    case NINE :
                        nIDRessource = R.drawable._9d;
                        break;
                    case TEN :
                        nIDRessource = R.drawable._10d;
                        break;
                    case JACK :
                        nIDRessource = R.drawable._jd;
                        break;
                    case QUEEN :
                        nIDRessource = R.drawable._qd;
                        break;
                    case KING :
                        nIDRessource = R.drawable._kd;
                        break;
                    case ACE :
                        nIDRessource = R.drawable._ad;
                        break;
                }
                break;
            case HEARTS :
                switch (oRank){
                    case TWO :
                        nIDRessource = R.drawable._2h;
                        break;
                    case THREE :
                        nIDRessource = R.drawable._3h;
                        break;
                    case FOUR :
                        nIDRessource = R.drawable._4h;
                        break;
                    case FIVE :
                        nIDRessource = R.drawable._5h;
                        break;
                    case SIX :
                        nIDRessource = R.drawable._6h;
                        break;
                    case SEVEN :
                        nIDRessource = R.drawable._7h;
                        break;
                    case EIGHT :
                        nIDRessource = R.drawable._8h;
                        break;
                    case NINE :
                        nIDRessource = R.drawable._9h;
                        break;
                    case TEN :
                        nIDRessource = R.drawable._10h;
                        break;
                    case JACK :
                        nIDRessource = R.drawable._jh;
                        break;
                    case QUEEN :
                        nIDRessource = R.drawable._qh;
                        break;
                    case KING :
                        nIDRessource = R.drawable._kh;
                        break;
                    case ACE :
                        nIDRessource = R.drawable._ah;
                        break;
                }
                break;

            case SPADES :
                switch (oRank){
                    case TWO :
                        nIDRessource = R.drawable._2s;
                        break;
                    case THREE :
                        nIDRessource = R.drawable._3s;
                        break;
                    case FOUR :
                        nIDRessource = R.drawable._4s;
                        break;
                    case FIVE :
                        nIDRessource = R.drawable._5s;
                        break;
                    case SIX :
                        nIDRessource = R.drawable._6s;
                        break;
                    case SEVEN :
                        nIDRessource = R.drawable._7s;
                        break;
                    case EIGHT :
                        nIDRessource = R.drawable._8s;
                        break;
                    case NINE :
                        nIDRessource = R.drawable._9s;
                        break;
                    case TEN :
                        nIDRessource = R.drawable._10s;
                        break;
                    case JACK :
                        nIDRessource = R.drawable._js;
                        break;
                    case QUEEN :
                        nIDRessource = R.drawable._qs;
                        break;
                    case KING :
                        nIDRessource = R.drawable._ks;
                        break;
                    case ACE :
                        nIDRessource = R.drawable._as;
                        break;
                }
                break;
            case CLUBS :
                switch (oRank){
                    case TWO :
                        nIDRessource = R.drawable._2c;
                        break;
                    case THREE :
                        nIDRessource = R.drawable._3c;
                        break;
                    case FOUR :
                        nIDRessource = R.drawable._4c;
                        break;
                    case FIVE :
                        nIDRessource = R.drawable._5c;
                        break;
                    case SIX :
                        nIDRessource = R.drawable._6c;
                        break;
                    case SEVEN :
                        nIDRessource = R.drawable._7c;
                        break;
                    case EIGHT :
                        nIDRessource = R.drawable._8c;
                        break;
                    case NINE :
                        nIDRessource = R.drawable._9c;
                        break;
                    case TEN :
                        nIDRessource = R.drawable._10c;
                        break;
                    case JACK :
                        nIDRessource = R.drawable._jc;
                        break;
                    case QUEEN :
                        nIDRessource = R.drawable._qc;
                        break;
                    case KING :
                        nIDRessource = R.drawable._kc;
                        break;
                    case ACE :
                        nIDRessource = R.drawable._ac;
                        break;
                }
                break;
        }


        return nIDRessource;



    }
}
