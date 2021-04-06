package com.ui2;

import javax.swing.*;
import com.codebind.*;

import java.awt.*;

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
        clickCounterUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickCounterUI.setContentPane(new clickCounterUI().rootPanel);
        clickCounterUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clickCounterUI.pack();
        clickCounterUI.setLocationRelativeTo(null);
        clickCounterUI.setVisible(false);
        System.out.println("clickCounterUI loaded");

        //clickTimerUI start (should only happen once)
        JFrame clickTimerUI = new JFrame("clickTimerUI");
        clickTimerUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickTimerUI.setContentPane(new clickTimerUI().rootPanel);
        clickTimerUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clickTimerUI.pack();
        clickTimerUI.setLocationRelativeTo(null);
        System.out.println("clickTimerUI loaded");

        //clickerConfigUI start (should only happen once)
        JFrame clickerConfigUI = new JFrame("clickerConfigUI");
        clickerConfigUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        clickerConfigUI.setContentPane(new clickerConfigUI().rootPanel);
        clickerConfigUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clickerConfigUI.pack();
        clickerConfigUI.setLocationRelativeTo(null);
        System.out.println("clickerConfigUI loaded");

        clickerCounterButton.addActionListener(e -> {
            //toggle visible code
            if (toggle1 == 0) {
                System.out.println("sorry, clickerBoard is a launcher used to launch one program at a time. If you want to launch something else, restart clickerBoard");
                JOptionPane.showMessageDialog(null,
                        "sorry, clickerBoard is a launcher used to launch one program at a time. \nIf you want to launch something else, restart clickerBoard",
                        "error",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            } else {
                clickCounterUI.setVisible(true);
                System.out.println("clickCounterUI.setVisible(true);");
                toggle1 = 0;
            }
        });
        clickerTimerButton.addActionListener(e -> {
            //toggle visible code
            if (toggle2 == 0) {
                System.out.println("sorry, clickerBoard is a launcher used to launch one program at a time. If you want to launch something else, restart clickerBoard");
                JOptionPane.showMessageDialog(null,
                        "sorry, clickerBoard is a launcher used to launch one program at a time. \nIf you want to launch something else, restart clickerBoard",
                        "error",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            } else {
                clickTimerUI.setVisible(true);
                System.out.println("clickTimerUI.setVisible(true);");
                toggle2 = 0;
            }
        });
        settingInfoButton.addActionListener(e -> {
            //toggle visible code
            if (toggle3 == 0) {
                System.out.println("sorry, clickerBoard is a launcher used to launch one program at a time. If you want to launch something else, restart clickerBoard");
                JOptionPane.showMessageDialog(null,
                        "sorry, clickerBoard is a launcher used to launch one program at a time. \nIf you want to launch something else, restart clickerBoard",
                        "error",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            } else {
                clickerConfigUI.setVisible(true);
                System.out.println("clickerConfigUI.setVisible(true);");
                toggle3 = 0;
            }
        });
    }
}
