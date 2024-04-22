package com.example.cardgamemvc.Game.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.cardgamemvc.R;
import com.example.cardgamemvc.databinding.FragmentWelcomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;


    public WelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_welcome, container, false);

        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        binding.btnPlay.setOnClickListener(view1 -> {

            String sNamePlayer1 = binding.txtPlayer1.getText().toString();
            String sNamePlayer2 = binding.txtPlayer2.getText().toString();

            boolean bPlayersNamed = true;

            if (sNamePlayer1.isEmpty()){
                Toast.makeText(this.getContext(), "Please enter the name of player 1", Toast.LENGTH_SHORT).show();
                bPlayersNamed = false;
            }

            if (sNamePlayer2.isEmpty()){
                Toast.makeText(this.getContext(), "Please enter the name of player 2", Toast.LENGTH_SHORT).show();
                bPlayersNamed = false;
            }

            if (bPlayersNamed){

                // Ouvre le jeu
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                GameFragment gameFragment = GameFragment.newInstance(sNamePlayer1,sNamePlayer2);
                fragmentTransaction.replace(R.id.fragment_main, gameFragment);
                fragmentTransaction.commit();
            }

        });


    }


}