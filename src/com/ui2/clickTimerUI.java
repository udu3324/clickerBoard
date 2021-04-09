package com.ui2;

import com.codebind.*;

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

    public clickTimerUI() throws FileNotFoundException {
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
                //writer
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
            if (save.saveClickerTimerAuto == 1) {
                try {
                    FileWriter myWriter = new FileWriter("clickerSaves.txt", true);
                    myWriter.write("> User has scored " + save.count2 + " points in " + df.format(save.duration) + " time. \n");
                    if (save.count2 == 1) {
                        myWriter.write("> Rating: you didn't even try LOL \n");
                    }
                    myWriter.write("\n");
                    myWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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
