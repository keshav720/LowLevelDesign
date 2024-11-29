package models.match;

import models.innings.InningDetails;
import models.teams.Team;

import java.util.*;

public class Match {
    public Team teamA;
    public Team teamB;
    public String venue;
    public Date matchDate;
    public Team tossWinner;
    public InningDetails[] innings;
    public MatchType matchType;

    public Match(Team teamA, Team teamB, String venue, MatchType matchType) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.venue = venue;
        this.matchType = matchType;
        this.innings = new InningDetails[2];
    }

    public void startMatch() throws Exception {
        InningDetails inningDetails = null;
        Team battingTeam = null;
        Team bowlingTeam = null;
        this.tossWinner = tossWinner(teamA, teamB);

        for(int inningIndex = 1; inningIndex <= 2; inningIndex++) {
            // assume here , toss winners will Bat first
            boolean isChasing = false;
            if(inningIndex == 1) {
                battingTeam = this.tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.startOver(-1);
            }
            else if(inningIndex == 2) {
                bowlingTeam = this.tossWinner;
                battingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
                inningDetails.startOver(innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRuns() > innings[0].getTotalRuns()) {
                    bowlingTeam.isWinnner = true;
                }
            }
            this.innings[inningIndex-1] = inningDetails;

            System.out.println();
            System.out.println("INNING " + innings + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.teamName + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
            bowlingTeam.printBowlingScoreCard();

        }
        System.out.println();
        if(teamA.isWinnner){
            System.out.println("---WINNER---" + teamA.teamName);

        }else {
            System.out.println("---WINNER---" + teamB.teamName);

        }
    }

    private Team tossWinner(Team teamA, Team teamB) {
        if(Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }

}
