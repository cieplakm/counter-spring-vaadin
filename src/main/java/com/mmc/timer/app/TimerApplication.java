package com.mmc.timer.app;

import com.mmc.timer.app.UI.TimerUI;
import com.mmc.timer.app.timer.Timer;
import com.mmc.timer.app.timer.TimerListener;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimerApplication.class, args);

	}

}
