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

        save.timer = new Timer(20, new ActionListener() { //timer module
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save.startTime < 0) { //if time reaches 0, stop time so it doesn't go to negative int
                    save.startTime = System.currentTimeMillis(); //use system time
                }
                long now = System.currentTimeMillis(); //use system time
                long clockTime = now - save.startTime;
                if (clockTime >= save.duration) { //whenever clock reaches 0, run command under:
                    clockTime = save.duration;
                    save.timer.stop(); //stop the timer from going to the negatives

                    //replace with diff label
                    hack.setEnabled(false); //disables hack button as timer went to 0
                    reset.setEnabled(true); //enable reset button to play again

                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS"); //format of time shown

                //replace with diff label
                time.setText(df.format(save.duration - clockTime)); //set time component to destination
            }
        });
        save.timer.setInitialDelay(save.delay); //set the delay

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
