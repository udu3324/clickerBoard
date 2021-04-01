package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
        //todo
        timerDisplayLabel.setText("string that turns format of int to mm:ss.SSS");

        save.timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save.startTime < 0) {
                    save.startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long clockTime = now - save.startTime;
                if (clockTime >= save.duration) {
                    clockTime = save.duration;
                    save.timer.stop();
                    clickerTimerButton.setEnabled(false);
                    clickerResetButton.setEnabled(true);
                    System.out.println("time ended.");
                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");

                timerDisplayLabel.setText(df.format(save.duration - clockTime));
            }
        });

        clickerTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save.count2++;
                clickerScoreLabel.setText("" + save.count2);

                if (!save.timer.isRunning()) {
                    save.startTime = -1;
                    save.timer.start();
                    System.out.println("time started");
                }
            }
        });
        clickerResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("person has scored " + save.count2 + " points");
                save.count2 = 0;
                clickerScoreLabel.setText("" + save.count2);
                clickerTimerButton.setEnabled(true);
                System.out.println("counter2 reset");
            }
        });
    }
}
