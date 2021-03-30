package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickTimerUI {
    public JPanel rootPanel;
    private JButton clickerTimerButton;
    private JLabel counterLabel;
    private JLabel titleLabel;
    private JLabel creditsLabel;
    private JLabel versionLabel;
    private JLabel clickerScoreLabel;
    private JButton clickerResetButton;
    private JLabel timerDisplayLabel;

    public clickTimerUI() {
        saveState save = new saveState();

        versionLabel.setText("v" + save.version);

        clickerTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clickerResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
