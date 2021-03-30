package com.ui2;

import javax.swing.*;
import com.codebind.*;

public class startUI {

    public JPanel rootPanel;
    private JButton clickerTimerButton;
    private JButton clickerCounterButton;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JButton settingInfoButton;

    //internal toggle variables
    int toggle1 = 1;
    int toggle2 = 1;
    int toggle3 = 1;

    public startUI() {

        saveState save = new saveState(); //load

        //change version to current one in saveState
        versionLabel.setText("v" + save.version);

        //clickCounterUI start (should only happen once)
        JFrame clickCounterUI = new JFrame("clickCounterUI");
        clickCounterUI.setContentPane(new clickCounterUI() .rootPanel);
        clickCounterUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        clickCounterUI.pack();
        clickCounterUI.setLocationRelativeTo(null);
        clickCounterUI.setVisible(false);
        System.out.println("clickCounterUI loaded");

        //clickTimerUI start (should only happen once)
        JFrame clickTimerUI = new JFrame("clickTimerUI");
        clickTimerUI.setContentPane(new clickTimerUI() .rootPanel);
        clickTimerUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        clickTimerUI.pack();
        clickTimerUI.setLocationRelativeTo(null);
        System.out.println("clickTimerUI loaded");

        //settingsUI start (should only happen once)
        JFrame settingsUI = new JFrame("settingsUI");
        settingsUI.setContentPane(new settingsUI() .rootPanel);
        settingsUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        settingsUI.pack();
        settingsUI.setLocationRelativeTo(null);
        System.out.println("settingsUI loaded");

        clickerCounterButton.addActionListener(e -> {
            //toggle visible code
            if (toggle1 == 0) {
                clickCounterUI.setVisible(false);
                System.out.println("clickCounterUI.setVisible(false);");
                toggle1 = 1;
            }   else {
                clickCounterUI.setVisible(true);
                System.out.println("clickCounterUI.setVisible(true);");
                toggle1 = 0;
            }
        });
        clickerTimerButton.addActionListener(e -> {
            //toggle visible code
            if (toggle2 == 0) {
                clickTimerUI.setVisible(false);
                System.out.println("clickTimerUI.setVisible(false);");
                toggle2 = 1;
            }   else {
                clickTimerUI.setVisible(true);
                System.out.println("clickTimerUI.setVisible(true);");
                toggle2 = 0;
            }
        });
        settingInfoButton.addActionListener(e -> {
            //toggle visible code
            if (toggle3 == 0) {
                settingsUI.setVisible(false);
                System.out.println("settingsUI.setVisible(false);");
                toggle3 = 1;
            }   else {
                settingsUI.setVisible(true);
                System.out.println("settingsUI.setVisible(true);");
                toggle3 = 0;
            }
        });
    }
}
