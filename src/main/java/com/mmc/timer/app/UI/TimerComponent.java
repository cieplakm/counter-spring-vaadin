package com.mmc.timer.app.UI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

@Component
public class TimerComponent extends VerticalLayout {
    Label timer;

    public TimerComponent() {
        setWidth("100%");
        timer = new Label("00:00");
        timer.setStyleName(ValoTheme.LABEL_H1);

        addComponent(timer);
        setComponentAlignment(timer, Alignment.MIDDLE_CENTER);
    }

    public void update(String time){
        timer.setValue(time);
    }
}
