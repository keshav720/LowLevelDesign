package scoreUpdater;

import models.innings.BallDetails;
import models.innings.BallType;
import models.innings.RunType;

public class BowlingScoreUpdater implements ScoreUpdateObserver{
    @Override
    public void update(BallDetails ballDetails) {
        if(ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL)
        {
            ballDetails.bowledBy.bowlingScoreCard.totalOversCount++;
        }

        if(ballDetails.runType == RunType.ONE){
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 1;
        }
        else if(ballDetails.runType == RunType.TWO){
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 2;
        }
        else if(ballDetails.runType == RunType.THREE){
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 3;
        }
        else if(ballDetails.runType == RunType.FOUR){
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 4;
        }
        else if(ballDetails.runType == RunType.SIX){
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 6;
        }

        if(ballDetails.wicket != null)
        {
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if(ballDetails.ballType == BallType.NOBALL){
            ballDetails.bowledBy.bowlingScoreCard.noBallCount++;
        }
        if(ballDetails.ballType == BallType.WIDEBALL){
            ballDetails.bowledBy.bowlingScoreCard.wideBallCount++;
        }
    }
}
