package com.example.cardgamemvc.Game.View;

import com.example.cardgamemvc.Game.Controller.GameController;

/**
 * Interface qui définit les méthodes à implémenter pour une Activité de façon à ce qu'elle puisse interagir avec le controller
 * C'est le I de SOLID -> Implémentation d'interfaces simples et maintenables
 */
public interface GameViewable {

    public void promptForPlayerName();

    public void setController(GameController gameControllerP);

    /**
     * Demande de retourner la carte (la rendre visible)
     */
    public void promptForFlip();

    /**
     * Réaffiche le nouveau jeu (jeu suivant)
     */
    public void promptForNewGame();

    public void showFaceDownCardForPlayer(int nIndexPlayerP, String sNamePlayerP);

    void AddInConsole(String s);

    public void showCardForPlayer(int nIndexPlayerP, String sNamePlayerP, String sRankP, String sSuitP);

    /**
     * Affiche le nom du joueur saisi
     */
    public void showPlayerName(int nNbPlayers, String sPlayerNameP);

    public void showWinner(String sWinnerNameP);
}
