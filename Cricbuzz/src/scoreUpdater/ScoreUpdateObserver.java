package scoreUpdater;

import models.innings.BallDetails;

public interface ScoreUpdateObserver {
    public void update(BallDetails ballDetails);
}
