package com.mmc.timer.app.UI;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import org.springframework.stereotype.Component;

@Component
public class AddPanel extends HorizontalLayout {
    Button btnStart;
    public AddPanel() {
        btnStart = new Button("Start");
        TextField textField = new TextField();

        textField.setPlaceholder("e.i. 5 minutes");

        btnStart.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        addComponent(textField);
        addComponent(btnStart);
    }

    public void setBtnListener(Button.ClickListener clickListener){
        btnStart.addClickListener( clickListener );
    }

}
