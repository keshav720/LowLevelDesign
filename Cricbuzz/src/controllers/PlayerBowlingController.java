package controllers;

import models.players.PlayerDetails;

import java.util.*;

public class PlayerBowlingController {
    Deque<PlayerDetails> bowlersList;
    PlayerDetails currentBowler;
    Map<PlayerDetails, Integer> bowlerVsOverCount;

    public PlayerBowlingController(List<PlayerDetails> bowlersList) {
        setBowlerList(bowlersList);
    }

    private void setBowlerList(List<PlayerDetails> bowlersList) {
        this.bowlersList = new ArrayDeque<>(bowlersList);
        this.bowlerVsOverCount = new HashMap<>();

        for(PlayerDetails player : bowlersList) {
            bowlerVsOverCount.put(player, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        PlayerDetails playerDetails = bowlersList.poll();
        if(bowlerVsOverCount.get(playerDetails)+1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        }
        else {
            currentBowler = playerDetails;
            bowlersList.addLast(playerDetails);
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails)+1);
        }

    }

    public PlayerDetails getCurrentBowler() {
        return currentBowler;
    }
}
