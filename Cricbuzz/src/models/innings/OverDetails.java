package models.innings;

import models.players.PlayerDetails;
import models.teams.Team;

import java.util.*;

public class OverDetails {
    public int overNumber;
    public List<BallDetails> balls;
    public int extraBallsCount;
    public PlayerDetails bowledBy;

    public OverDetails(int overNumber, PlayerDetails bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        this.balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 1;
        while (ballCount <= 6){

            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.ballType == BallType.NORMAL){
                ballCount++;
                if(ball.wicket != null){
                    battingTeam.chooseNextBatsman();
                }
                if(runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.isWinnner = true;
                    return true;
                }
            }
            else {
                this.extraBallsCount++;
            }
        }
        return false;
    }
}
