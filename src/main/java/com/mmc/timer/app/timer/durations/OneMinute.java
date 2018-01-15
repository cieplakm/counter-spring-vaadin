package com.mmc.timer.app.timer.durations;

public class OneMinute implements Duration {
    @Override
    public int containsSeconds() {
        return 60;
    }
}
