package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class clickCounterUI {
    public JPanel rootPanel;
    private JButton clickerCounterButton;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JLabel titleLabel;
    private JLabel counterLabel;
    private JButton clickerReset;
    private JLabel infoLabel;

    public clickCounterUI() throws FileNotFoundException {

        saveState save = new saveState(); //load

        versionLabel.setText("v" + save.version);
        infoLabel.setText("[ Highest Score | " + save.highestCount0 + " ]");

        clickerCounterButton.addActionListener(e -> {
            save.count++;
            counterLabel.setText("" + save.count);

            //easter egg
            if (save.count == 1000000000) {
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
                //operation to set highestCount0 only if it is actually the highest number count
                if (save.count > save.highestCount0) {
                    save.highestCount0 = save.count;
                    infoLabel.setText("[ Highest Score | " + save.highestCount0 + " ]");
                    System.out.println("great job! your new highest score is " + save.highestCount0);
                    try {
                        File myObj = new File("clickerConfig.txt");
                        BufferedWriter out = new BufferedWriter(new FileWriter(myObj));
                        out.write("# clickerBoard is by _._#3324/udu3324. \r\n");
                        out.write("# use clickerConfig to edit values safer. \r\n");
                        out.write("# read docs if you need help editing values. \r\n");
                        out.write("# only do things like edit integers! file is sensitive.\r\n");
                        out.write("# if something wrong happens, delete the file and run clickerBoard again.\r\n");
                        out.write("\r\n");
                        out.write("# 1 = true | 0 = false \r\n");
                        out.write("saveClickerTimerAuto = " + save.saveClickerTimerAuto + " \r\n");
                        out.write("\r\n");
                        out.write("# duration is in milliseconds \r\n");
                        out.write("duration = " + save.duration +"\r\n");
                        out.write("\r\n");
                        out.write("clickerTimer High Score = " + save.highestCount + "\r\n");
                        out.write("clickerCounter High Score = " + save.highestCount0 + "\r\n");
                        out.write("\r\n");
                        out.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException a) {
                        System.out.println("An error occurred.");
                        a.printStackTrace();
                    }
                }
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
