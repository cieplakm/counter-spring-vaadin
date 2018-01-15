package com.mmc.timer.app.timer;

public interface TimerListener {
    void nowTimeIs(String timeLeft);
    void reachEnd();
    void reachedTimeStamp();
}
