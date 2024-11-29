package models.innings;

import models.match.MatchType;
import models.players.PlayerDetails;
import models.teams.Team;

import java.util.*;

public class InningDetails {
    public Team battingTeam;
    public Team bowlingTeam;
    public MatchType matchType;
    public List<OverDetails> overDetails;

    public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overDetails = new ArrayList<>();
    }

    public void startOver(int runsToWin) throws Exception {
        try {
            battingTeam.chooseNextBatsman();
        }
        catch (Exception e){

        }
        int noOfOvers = matchType.noOfOvers();
        for(int overNumber = 1; overNumber <= noOfOvers; overNumber++){
            bowlingTeam.chooseNextBowler(matchType.maxOverPerBowler());
            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overDetails.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if (won) {
                    break;
                }
            }
            catch (Exception e){
                break;
            }
            //swap striket and non striker
            PlayerDetails temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
        }


    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }

}

