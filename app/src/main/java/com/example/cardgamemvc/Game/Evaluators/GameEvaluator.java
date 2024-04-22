package com.example.cardgamemvc.Game.Evaluators;

import com.example.cardgamemvc.Game.Model.Player;

import java.util.List;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> aPlayersP);
}