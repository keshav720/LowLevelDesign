package models.teams;

import controllers.PlayerBattingController;
import controllers.PlayerBowlingController;
import models.players.PlayerDetails;

import java.util.*;

public class Team {
    public String teamName;
    public Queue<PlayerDetails> playing11;
    public List<PlayerDetails> benchPlayers;
    public PlayerBattingController playerBattingController;
    public PlayerBowlingController playerBowlingController;
    public boolean isWinnner;

    public Team(String teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> benchPlayers, List<PlayerDetails> bowlers) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.benchPlayers = benchPlayers;
        this.playerBattingController = new PlayerBattingController(playing11);
        this.playerBowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Queue<PlayerDetails> getPlaying11() {
        return playing11;
    }

    public void setPlaying11(Queue<PlayerDetails> playing11) {
        this.playing11 = playing11;
    }

    public List<PlayerDetails> getBenchPlayers() {
        return benchPlayers;
    }

    public void setBenchPlayers(List<PlayerDetails> benchPlayers) {
        this.benchPlayers = benchPlayers;
    }

    public void chooseNextBatsman() throws Exception {
        playerBattingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler) throws Exception {
        playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails getStriker() {
        return playerBattingController.getStriker();
    }

    public void setStriker(PlayerDetails striker) {
        playerBattingController.setStriker(striker);
    }

    public PlayerDetails getNonStriker() {
        return playerBattingController.getNonStriker();
    }

    public void setNonStriker(PlayerDetails nonStriker) {
        playerBattingController.setNonStriker(nonStriker);
    }

    public PlayerDetails getCurrentBowler(){
        return playerBowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for(PlayerDetails p : playing11){
            p.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        for(PlayerDetails p : playing11) {
            if(p.bowlingScoreCard.totalOversCount > 0){
                p.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for(PlayerDetails p : playing11){
            totalRuns += p.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }

}
