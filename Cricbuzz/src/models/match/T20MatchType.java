package models.match;

public class T20MatchType implements MatchType{
    @Override
    public int noOfOvers() {
        return 20;
    }

    @Override
    public int maxOverPerBowler() {
        return 4;
    }
}
