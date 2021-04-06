package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class clickTimerUI {
    public JPanel rootPanel;
    private JButton clickerTimerButton;
    private JLabel titleLabel;
    private JLabel versionLabel;
    private JLabel clickerScoreLabel;
    private JButton clickerResetButton;
    private JLabel timerDisplayLabel;
    private JLabel infoLabel;
    private JLabel creditsLabel;

    public clickTimerUI() {
        saveState save = new saveState();
        SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");

        versionLabel.setText("v" + save.version);
        timerDisplayLabel.setText(df.format(save.duration));
        infoLabel.setText("[ Highest Score | " + save.highestCount + " ]" + " [ Initial Time | " + df.format(save.duration) + " ]");

        save.timer = new Timer(0, e -> {
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
                System.out.println("time ended :(");
            }
            timerDisplayLabel.setText(df.format(save.duration - clockTime));
        });

        clickerTimerButton.addActionListener(e -> {
            save.count2++;
            clickerScoreLabel.setText("" + save.count2);

            if (!save.timer.isRunning()) {
                save.startTime = -1;
                save.timer.start();
                System.out.println("time started, go go go!!!");
            }
        });
        clickerResetButton.addActionListener(e -> {
            //operation to set highestCount0 only if it is actually the highest number count
            if (save.count2 > save.highestCount) {
                save.highestCount = save.count2;
                infoLabel.setText("[ Highest Score | " + save.highestCount + " ]" + " [ Initial Time | " + df.format(save.duration) + " ]");
                System.out.println("great job! your new highest score is " + save.highestCount);
            }
            //set the timerLabel back to its original number
            timerDisplayLabel.setText(df.format(save.duration));
            System.out.println("person has scored " + save.count2 + " points");
            save.count2 = 0;
            clickerScoreLabel.setText("" + save.count2);
            clickerTimerButton.setEnabled(true);
            clickerResetButton.setEnabled(false);
            System.out.println("counter2 reset");
        });
    }
}
