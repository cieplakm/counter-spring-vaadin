package com.mmc.timer.app.timer.durations;

public class Minute implements Duration {
    @Override
    public int containsSeconds() {
        return 60;
    }
}
