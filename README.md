**CRICBUZZ LLD** 

**Requirement Gathering**

1.Match Management:
Add, update, and retrieve match details, including teams participating, location, and match type.
Store and manage innings details for both teams.

2.Team Management:
Manage team details, including the playing XI and bench players.
Store player details, including player type (batsman, bowler, wicketkeeper, all-rounder, captain).

3.Innings Tracking:
Track which team is batting and which is bowling in each inning.
Record and retrieve details of each over bowled in the inning.

4.Over and Ball Tracking:
Record details for each over, including the bowler and sequence of ball events.
Track ball-by-ball details such as runs scored, ball type (normal, no-ball, wide), and player actions.
Handle extras such as no-balls and wides appropriately in the score tally.

5.Wicket Management:
Record wicket details, including the type of dismissal (e.g., bowled, caught) and the players involved.
Link the wicket event to the specific over and ball it occurred on.

6.Run Type Classification:
Categorize runs scored into types (e.g., singles, doubles, boundaries, sixes).
Track runs scored by individual players and total team score.

7.Player Performance Tracking:
Record batting statistics (runs, balls faced, strike rate).
Record bowling statistics (overs bowled, runs conceded, wickets taken).




**UML Diagram for Cricbuzz Low-Level Design**


**Classes:**
1.Match
2.Team
3.InningDetails
4.PlayerDetails
5.BallDetails
6.Ball Type(NOBALL, WIDE BALL)
7.OverDetails
8.Wicket
9.RUN TYPE(ONE, TWO, THREE, FOUR,SIX)
10.Player TYPE(BATSMAN, BOWLER, WICKETKEEPER, ALLROUNDER, CAPTAIN)

**Class Relationships:**
1. Match class contains two Teams and List of Inning details.
2. Team class contains player details ( playing 11 and bench players).
3. InningDetails class contain batting and bowling team details and each overDetails.
4. OverDetails class contains multiple BallDetails, including details of extra balls (e.g., wide balls, no balls). It also includes information about the player who bowled the over.
5. BallDetails class contains details of the player who bowled the ball and the player who played the ball. It also includes wicket details if a wicket was taken on that ball; otherwise, it stores a null value for the wicket.
6. The Wicket class contains details of the player who took the wicket, along with references to the OverDetails and BallDetails where the wicket occurred.

Let me create the UML diagram.





 
