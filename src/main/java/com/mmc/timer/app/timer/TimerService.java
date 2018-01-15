package com.mmc.timer.app.timer;

import com.mmc.timer.app.timer.durations.Duration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class TimerService {

    public TimerService() {
        System.out.println("Nowy service!!!! -#^#&$#@*#@*&($%^&W$%^@%^@$%^#%&#56---------------------------------------");
    }

    @Async
    public void coundDown(Duration duration, TimerListener timerListener){
        Timer timer = new Timer(duration, timerListener);
        timer.start();
        System.out.println(" --------------:)-------------------------");
    }
}
