package com.ui2;

import javax.swing.*;
import com.codebind.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

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

    public startUI() throws FileNotFoundException {
        saveState save = new saveState(); //load

        //change version to current one in saveState
        versionLabel.setText("v" + save.version);

        //clickCounterUI start (should only happen once)
        JFrame clickCounterUI = new JFrame("clickCounterUI");
        clickCounterUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickCounterUI.setContentPane(new clickCounterUI().rootPanel);
        clickCounterUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        clickCounterUI.pack();
        clickCounterUI.setLocationRelativeTo(null);
        clickCounterUI.setResizable(false);
        clickCounterUI.setVisible(false);
        System.out.println("clickCounterUI loaded");

        //clickTimerUI start (should only happen once)
        JFrame clickTimerUI = new JFrame("clickTimerUI");
        clickTimerUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickTimerUI.setContentPane(new clickTimerUI().rootPanel);
        clickTimerUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        clickTimerUI.pack();
        clickTimerUI.setLocationRelativeTo(null);
        clickTimerUI.setResizable(false);
        clickTimerUI.setVisible(false);
        System.out.println("clickTimerUI loaded");

        //clickerConfigUI start (should only happen once)
        JFrame clickerConfigUI = new JFrame("clickerConfigUI");
        clickerConfigUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickerConfigUI.setContentPane(new clickerConfigUI().rootPanel);
        clickerConfigUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        clickerConfigUI.pack();
        clickerConfigUI.setLocationRelativeTo(null);
        clickerConfigUI.setResizable(false);
        clickerConfigUI.setVisible(false);
        System.out.println("clickerConfigUI loaded");

        clickCounterUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                clickCounterUI.setVisible(false);
                toggle1 = 1;
            }
        });
        clickTimerUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                clickTimerUI.setVisible(false);
                toggle2 = 1;
            }
        });
        clickerConfigUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                clickerConfigUI.setVisible(false);
                toggle3 = 1;
            }
        });

        clickerCounterButton.addActionListener(e -> {
            //toggle visible code
            if (toggle1 == 0) {
                clickCounterUI.setVisible(false);
                System.out.println("clickCounterUI.setVisible(false);");
                toggle1 = 1;
            } else {
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
            } else {
                clickTimerUI.setVisible(true);
                System.out.println("clickTimerUI.setVisible(true);");
                toggle2 = 0;
            }
        });
        settingInfoButton.addActionListener(e -> {
            //toggle visible code
            if (toggle3 == 0) {
                clickerConfigUI.setVisible(false);
                System.out.println("clickerConfigUI.setVisible(false);");
                toggle3 = 1;
            } else {
                clickerConfigUI.setVisible(true);
                System.out.println("clickerConfigUI.setVisible(true);");
                toggle3 = 0;
            }
        });
    }
}
