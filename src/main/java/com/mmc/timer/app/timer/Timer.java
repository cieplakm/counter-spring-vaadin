package com.mmc.timer.app.timer;

import com.mmc.timer.app.timer.durations.Duration;

/**This class should count down from some time to 0:00.
 * It can be SECOND, MINUTE, HOUR etc. - this define by object of class Type
 * You can define some points (Point class)in time from some time to 0 when this class inform listeners
 * about this point in time is reached.*/
public class Timer {

    private int counter;
    private Duration duration;
    private TimerListener timerListener;

    public Timer(Duration duration) {

        this.duration = duration;
        counter = duration.containsSeconds();

    }

    public void start(){
        countDown();
    }

    private void countDown() {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter--;
            timerListener.nowIs(Integer.toString(counter));
        }while (counter == 0);
    }

    public class Point{

    }

    public class Type implements Duration{

        private int seconds;

        public Type(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public int containsSeconds() {
            return seconds;
        }
    }
}
