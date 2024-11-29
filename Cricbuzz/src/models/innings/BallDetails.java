package models.innings;

import models.players.PlayerDetails;
import models.scores.BowlingScoreCard;
import models.teams.Team;
import models.teams.Wicket;
import models.teams.WicketType;
import scoreUpdater.BattingScoreUpdater;
import scoreUpdater.BowlingScoreUpdater;
import scoreUpdater.ScoreUpdateObserver;
import scoreUpdater.BowlingScoreUpdater;
import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    List<ScoreUpdateObserver> scoreUpdateObserverList = new ArrayList<>();

    public BallDetails(int ballNumber){
        this.ballNumber = ballNumber;
        scoreUpdateObserverList.add(new BattingScoreUpdater());
        scoreUpdateObserverList.add(new BowlingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails overDetails) {
        this.playedBy = battingTeam.getStriker();
        this.bowledBy = bowlingTeam.getCurrentBowler();
        //THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
        ballType = BallType.NORMAL;
        if(isWicketTaken()) {
            this.runType = RunType.ZERO;
            this.wicket = new Wicket(WicketType.BOWLED, bowlingTeam.getCurrentBowler(), overDetails, this);
            battingTeam.setStriker(null);
        }
        else{
            this.runType = getRunType();
                if(runType == RunType.ONE || runType == RunType.THREE) {
                    PlayerDetails temp = battingTeam.getStriker();
                    battingTeam.setStriker(battingTeam.getNonStriker());
                    battingTeam.setNonStriker(temp);
                }
        }
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails) {
        for(ScoreUpdateObserver observer : scoreUpdateObserverList){
            observer.update(ballDetails);
        }
    }

    private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }
}
