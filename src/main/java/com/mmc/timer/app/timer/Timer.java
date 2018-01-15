package com.mmc.timer.app.timer;

import com.mmc.timer.app.timer.durations.Duration;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**This class should count down from some time to 0:00.
 * It can be SECOND, MINUTE, HOUR etc. - this define by object of class Type
 * You can define some time (Stamp class)in time from some time to 0 when this class inform listeners
 * about this stamps in time is reached.
 * Precision +- 200ms*/
public class Timer {

    private long startTime;
    private Duration duration;
    private TimerListener timerListener;
    private Set<Stamp> stamps;

    public Timer(Duration duration, TimerListener timerListener) {
        this.timerListener = timerListener;
        this.duration = duration;

        stamps = new HashSet<>();
    }

    public void start(){
        startTime = getCurrentTime();
        countDown();
    }

    public long getCurrentTime(){
        return System.currentTimeMillis();
    }

    public void restart(){

    }

    public void addTimeStamp(Stamp stamp){
        stamps.add(stamp);
    }

    private void countDown() {
        int durationLong = 0;
        do {
            timerListener.nowTimeIs(Integer.toString(durationLong));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            durationLong = (int)(getCurrentTime() - startTime)/1000;

            timerListener.nowTimeIs(Integer.toString(durationLong));
            isStampReached(durationLong);

        }while ( durationLong < duration.containsSeconds());

        timerListener.reachEnd();
    }

    public void isStampReached(int counter){
        int timeFromBegining = duration.containsSeconds() - counter;

        for (Stamp  stamp: stamps ){
            if (timeFromBegining == stamp.afterDuration.containsSeconds() ){
                timerListener.reachedTimeStamp();
            }
        }
    }

    public static class Stamp {
        private Duration afterDuration;

        public Stamp(Duration afterDuration) {
            this.afterDuration = afterDuration;
        }
    }

}
