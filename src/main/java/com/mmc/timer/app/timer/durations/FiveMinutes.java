package com.mmc.timer.app.timer.durations;

public class FiveMinutes implements Duration {
    @Override
    public int containsSeconds() {
        return 5*60;
    }
}
