package com.example.cardgamemvc.Game.Model;

public class Player {


    private String sPlayerName;

    private Hand oHand = new Hand();

    public Player(String sPlayerNameP) {
        this.sPlayerName = sPlayerNameP;
    }

    public String getsPlayerName() {
        return sPlayerName;
    }

    public void addCardToHand(PlayingCard oCardP){
        oHand.addCard(oCardP);
    }

    public PlayingCard removeCard(){
        return oHand.removeCard();
    }

    public PlayingCard getCard(int nIndexP){
        return oHand.getCard(nIndexP);
    }
}
