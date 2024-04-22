package com.example.cardgamemvc.Game.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cardgamemvc.Game.Controller.GameController;
import com.example.cardgamemvc.Game.Evaluators.HighCardGameEvaluator;
import com.example.cardgamemvc.Game.Model.Deck;
import com.example.cardgamemvc.Game.Model.DeckFactory;
import com.example.cardgamemvc.R;
import com.example.cardgamemvc.databinding.FragmentGameBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment implements IGameViewable {

    private FragmentGameBinding binding;

    private String sNamePlayer1;
    private String sNamePlayer2;

    GameController oController;

    public static final String DOWN_CARD = "???"; // Carte retournée

    public GameFragment() {
        // Required empty public constructor
    }



    public void setController(GameController gameControllerP){
        this.oController=gameControllerP;
    }

    @Override
    public void showPlayersNames(int nIndexPlayerP, String sNamePlayerP) {

        switch (nIndexPlayerP) {

            // Player 1
            case 1:
                binding.txtPlayer1Name.setText(sNamePlayerP);
                break;

            // Player 2
            case 2:
                binding.txtPlayer2Name.setText(sNamePlayerP);
                break;

        }


    }

    @Override
    public void showFaceDownCardForPlayer(int nIndexPlayerP, String sNamePlayerP) {

        switch (nIndexPlayerP) {

            // Player 1
            case 1:
                binding.txtPlayer1Card.setText(DOWN_CARD);
                break;

            // Player 2
            case 2:
                binding.txtPlayer2Card.setText(DOWN_CARD);
                break;

        }

    }

    @Override
    public void showCardForPlayer(int nIndexPlayerP, String sNamePlayerP, String sRankP, String sSuitP) {

        String sValCard = sRankP+"-"+sSuitP;

        switch (nIndexPlayerP) {

            // Player 1
            case 1:
                binding.txtPlayer1Card.setText(sValCard);
                break;

            // Player 2
            case 2:
                binding.txtPlayer2Card.setText(sValCard);
                break;

        }

    }

    @Override
    public void showWinner(String sWinnerNameP) {

        // 1. Instantiate an AlertDialog.Builder with its constructor.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // 2. Chain together various setter methods to set the dialog characteristics.
        builder.setMessage("The winner is "+sWinnerNameP)
                .setTitle("Result");

        // 3. Get the AlertDialog.
        builder.setPositiveButton("OK", (dialog, id) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void goToWelcomeFragment() {
        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, welcomeFragment).commit();

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String sNamePlayer1P, String sNamePlayer2P) {

        GameFragment fragment = new GameFragment();

        fragment.sNamePlayer1 = sNamePlayer1P;
        fragment.sNamePlayer2 = sNamePlayer2P;

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false);

        binding = FragmentGameBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        oController.initPlayer();
        oController.addPlayer(sNamePlayer1);
        oController.addPlayer(sNamePlayer2);

        binding.txtPlayer1Card.setText(DOWN_CARD);
        binding.txtPlayer2Card.setText(DOWN_CARD);

        binding.btnPlay.setOnClickListener(view1 -> {
            oController.startGame();
            oController.flipCards();
        });

        binding.btnQuit.setOnClickListener(view1 -> {
            goToWelcomeFragment();
        });

    }
}