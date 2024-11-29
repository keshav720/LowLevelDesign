package controllers;

import models.players.PlayerDetails;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<PlayerDetails> battingQueue;
    PlayerDetails striker;
    PlayerDetails nonStriker;

    public PlayerBattingController(Queue<PlayerDetails> battingQueue) {
        this.battingQueue = new LinkedList<>();
        battingQueue.addAll(battingQueue);
    }

    public void getNextPlayer() throws Exception {
        if(battingQueue.isEmpty()){
        throw new Exception();
        }

        if(striker == null){
            striker = battingQueue.poll();
        }

        if(nonStriker == null){
            nonStriker = battingQueue.poll();
        }

    }

    public PlayerDetails getStriker() {
        return striker;
    }

    public void setStriker(PlayerDetails striker) {
        this.striker = striker;
    }

    public PlayerDetails getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        this.nonStriker = nonStriker;
    }


}
