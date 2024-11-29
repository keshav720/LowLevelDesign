package scoreUpdater;

import models.innings.BallDetails;
import models.innings.RunType;

public class BattingScoreUpdater implements ScoreUpdateObserver{
    @Override
    public void update(BallDetails ballDetails) {
        int run = 0;

        if(ballDetails.runType == RunType.ONE){
            run = 1;
        }
        else if(ballDetails.runType == RunType.TWO){
            run = 2;
        }
        else if(ballDetails.runType == RunType.THREE){
            run = 3;
        }
        else if(ballDetails.runType == RunType.FOUR){
            run = 4;
        }
        else if(ballDetails.runType == RunType.SIX){
            run = 6;
        }
        ballDetails.playedBy.battingScoreCard.totalRuns += run;
        ballDetails.playedBy.battingScoreCard.totalBallsPlayed++;

        if(ballDetails.wicket != null){
            ballDetails.playedBy.battingScoreCard.wicketDetails = ballDetails.wicket;
        }
    }
}
