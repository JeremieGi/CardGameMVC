package com.example.cardgamemvc.Game.Model;

public class Player {


    private String sPlayerName;

    private int nScore;

    private Hand oHand = new Hand();

    public Player(String sPlayerNameP) {
        this.sPlayerName = sPlayerNameP;
        this.nScore = 0;
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

    public void incrementeScore() {
        this.nScore++;
    }

    public Integer getScore() {
        return this.nScore;
    }
}
