package com.mmc.timer.app.timer.durations;

public class Hour implements Duration {
    @Override
    public int containsSeconds() {
        return 60*60;
    }
}
