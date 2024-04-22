package com.example.cardgamemvc.Game.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cardgamemvc.R;


public class MainActivity extends AppCompatActivity {

    // ****************** OVERRIDE ------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        binding=ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);

    }

    @Override
    protected void onStart() {

        super.onStart();

    }


}