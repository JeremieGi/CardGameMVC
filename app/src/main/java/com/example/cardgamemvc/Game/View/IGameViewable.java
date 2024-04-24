package com.example.cardgamemvc.Game.View;

import com.example.cardgamemvc.Game.Controller.GameController;

/**
 * Interface qui définit les méthodes à implémenter pour une Activité de façon à ce qu'elle puisse interagir avec le controller
 * C'est le I de SOLID -> Implémentation d'interfaces simples et maintenables
 */
public interface IGameViewable {

    public void setController(GameController gameControllerP);

    public void showPlayersNames(int nIndexPlayerP, String sNamePlayerP);

    public void showFaceDownCardForPlayer(int nIndexPlayerP, String sNamePlayerP);

    public void showCardForPlayer(int nIndexPlayerP, String sNamePlayerP, int nIDRessourceP, String sRessourceNameP);


    public void showWinner(String sWinnerNameP);
}
