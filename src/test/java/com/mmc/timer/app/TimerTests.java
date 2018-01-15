package com.mmc.timer.app;
import com.mmc.timer.app.timer.Timer;
import com.mmc.timer.app.timer.TimerListener;
import com.mmc.timer.app.timer.durations.Duration;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.assertj.core.api.Assertions.*;


public class TimerTests {
    TimerListener timerListener;
    Duration duration;
    @Before
    public void beforeTests(){
        timerListener = new TimerListener() {
            @Override
            public void nowTimeIs(String timeLeft) {
                System.out.println(timeLeft);
            }

            @Override
            public void reachEnd() {
                System.out.println("END!");
            }

            @Override
            public void reachedTimeStamp() {
                System.out.println("TimeStamp!");
            }
        };

        duration = () -> 5;
    }

    @Test
    public void should(){


        Timer timer = new Timer(duration, timerListener);

        timer.addTimeStamp(new Timer.Stamp(new Duration() {
            @Override
            public int containsSeconds() {
                return 2;
            }
        }));

        timer.addTimeStamp(new Timer.Stamp(new Duration() {
            @Override
            public int containsSeconds() {
                return 3;
            }
        }));

        long timeSt = System.currentTimeMillis();
        timer.start();
        long timeFt=  System.currentTimeMillis();
        System.out.println("Delay: " + (5*1000 - (timeFt-timeSt)) );
        assertThat((timeFt-timeSt)).isLessThan(5*1000+200);
        assertThat((timeFt-timeSt)).isGreaterThan(5*1000-200);

    }

}
