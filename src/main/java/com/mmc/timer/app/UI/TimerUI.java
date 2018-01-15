package com.mmc.timer.app.UI;

import com.mmc.timer.app.timer.Timer;
import com.mmc.timer.app.timer.TimerListener;
import com.mmc.timer.app.timer.TimerService;
import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@SpringUI
@Push
public class TimerUI extends UI implements TimerListener{

    @Autowired
    TimerService timerService;

    VerticalLayout rootLayout;
    AddPanel addPanel = new AddPanel();
    TimerComponent timerComponent = new TimerComponent();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupMainLayout();
        addHeader();
        addAddPanel();
        addTimerComponent();

    }

    private void setupMainLayout() {
        rootLayout = new VerticalLayout();
        setContent(rootLayout);
    }

    private void addHeader() {
        Label label = new Label("Timer");
        rootLayout.addComponent(label);
    }

    private void addTimerComponent() {
        rootLayout.addComponent(timerComponent);
    }

    private void addAddPanel() {
        addPanel.setBtnListener((Button.ClickListener) clickEvent -> {
            timerService.coundDown(()->10, TimerUI.this);
        });

        rootLayout.addComponent(addPanel);
    }

    @Override
    public void nowTimeIs(String timeLeft) {
        updateTimer(timeLeft);
    }

    private void updateTimer(String timeLeft) {
        access(new Runnable() {
            @Override
            public void run() {
                timerComponent.update(timeLeft);
            }
        });
    }

    @Override
    public void reachEnd() {

    }

    @Override
    public void reachedTimeStamp() {

    }
}
