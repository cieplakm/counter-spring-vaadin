package com.mmc.timer.app.UI;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
public class TimerUI extends UI{

    private VerticalLayout rootLayout;
    private TextField textField;
    private Button btnStart;
    private HorizontalLayout mainControllPanel;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupMainLayout();
        addHeader();
        addForm();

    }

    private void addHeader() {
        Label label = new Label("Timer");

        rootLayout.addComponent(label);
    }

    private void addForm() {

        btnStart = new Button("Start");

        textField = new TextField();

        textField.setPlaceholder("How many minutes should I count down?");

        btnStart.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        btnStart.addClickListener((event)->{
            new Notification("Started!").show(Page.getCurrent());
            hideStartButton();
        });

        mainControllPanel = new HorizontalLayout();

        mainControllPanel.addComponent(textField);
        mainControllPanel.addComponent(btnStart);

        rootLayout.addComponent(mainControllPanel);
    }

    private void hideStartButton() {
        mainControllPanel.removeComponent(btnStart);
    }

    private void setupMainLayout() {
        rootLayout = new VerticalLayout();
        setContent(rootLayout);
    }
}
