package com.example.cardgamemvc.Game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.cardgamemvc.Game.Controller.GameController;
import com.example.cardgamemvc.Game.Evaluators.HighCardGameEvaluator;
import com.example.cardgamemvc.Game.Evaluators.LowCardGameEvaluator;
import com.example.cardgamemvc.Game.Model.Deck;
import com.example.cardgamemvc.Game.Model.DeckFactory;
import com.example.cardgamemvc.Game.Model.NormalDeck;
import com.example.cardgamemvc.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements GameViewable {

    private ActivityMainBinding binding;

    GameController oController;

    /**
     * Saisie d'un joueur
     */
    public void promptForPlayerName(){

        String sName = binding.txtPlayerName.getText().toString();
        oController.addPlayer(sName);

    }

    public void setController(GameController gameControllerP){
        this.oController=gameControllerP;
    }

    /**
     * Demande de retourner la carte (la rendre visible)
     */
    public void promptForFlip() {
        // inutile -> Fait dans le bouton Flip
    }

    /**
     * Réaffiche le nouveau jeu (jeu suivant)
     */
    public void promptForNewGame() {
        // inutile -> Fait dans le bouton Run
    }

    public void showFaceDownCardForPlayer(int nIndexPlayerP, String sNamePlayerP) {
        AddInConsole("Player "+nIndexPlayerP+" is "+sNamePlayerP+" -> Card face down.");
    }

    public void AddInConsole(String s) {
        String sOldText = binding.txtGame.getText().toString();
        binding.txtGame.setText(String.format("%s\n%s", sOldText, s)); // Concaténation plus élégante
    }

    public void showCardForPlayer(int nIndexPlayerP, String sNamePlayerP, String sRankP, String sSuitP) {
        AddInConsole("Player "+nIndexPlayerP+" is "+sNamePlayerP+" -> Card "+sRankP+"/"+sSuitP);
    }

    /**
     * Affiche le nom du joueur saisi
     */
    public void showPlayerName(int nNbPlayers, String sPlayerNameP) {
        AddInConsole("Player "+nNbPlayers+" is "+sPlayerNameP);
    }

    public void showWinner(String sWinnerNameP) {
        AddInConsole("The winner is "+sWinnerNameP);
    }


    // ****************** OVERRIDE ------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // exemple d'utilisation d'une factory pour créer les jeus de carte
        Deck oDeck = DeckFactory.createDeck(DeckFactory.EDeskType.normal);

        // Instancie le controller
        // On pourrait changer le GameEvaluator facilement (=règle du jeu) avec une autre classe si besoin
        oController = new GameController(this,oDeck, new HighCardGameEvaluator());

        // Par exemple si on change les règles avec la plus petite carte qui gagne
        // C'est le O de SOLID : Principe ouvert / fermé
        // Ouvert = GameEvaluator / Fermé => Le controller qu'on ne touche pas
        //oController = new GameController(this,new Deck(), new LowCardGameEvaluator());

        //oController.run(); // je ne peux pas faire run en Android => les saisies ne sont pas bloquantes comme dans le cours

    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.btnAddPlayer.setOnClickListener(view1 -> {
            promptForPlayerName();
        });

        binding.btnRun.setOnClickListener(view1 -> {
            oController.startGame();
        });

        binding.btnFlip.setOnClickListener(view1 -> {
            oController.flipCards();
        });

    }
}