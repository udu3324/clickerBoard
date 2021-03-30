package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickCounterUI {
    public JPanel rootPanel;
    private JButton clickerCounterButton;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JLabel titleLabel;
    private JLabel counterLabel;
    private JButton clickerReset;

    public clickCounterUI() {

        saveState save = new saveState(); //load

        versionLabel.setText("v" + save.version);

        clickerCounterButton.addActionListener(e -> {
            save.count++;
            counterLabel.setText("" + save.count);

            //easter egg
            if (save.count == 69420) {
                //info dialog
                JOptionPane.showMessageDialog(null,
                        "you did it",
                        "lol",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
                System.out.println("lol");
            }
        });
        clickerReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save.count = 0;
                counterLabel.setText("" + save.count);
                JOptionPane.showMessageDialog(null,
                        "rip, you reset your counter",
                        "lol",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
                System.out.println("your counter reset");
            }
        });
    }
}
