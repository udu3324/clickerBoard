package com.ui2;

import com.codebind.saveState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class clickerConfigUI {
    public JPanel rootPanel;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JButton saveConfig;
    private JComboBox comboBoxTime;
    private JButton autoSaveToggle;
    private JButton clickerRefer;
    private JButton resetDefaultButton;

    public clickerConfigUI() throws FileNotFoundException {
        saveState save = new saveState(); //load

        //change version to current one in saveState
        versionLabel.setText("v" + save.version);

        //change auto save label to right one in config
        if (save.saveClickerTimerAuto == 1) {
            autoSaveToggle.setText("Auto-Save Scores (true)");
            System.out.println("save.saveClickerTimerAuto = true");
        }
        if (save.saveClickerTimerAuto == 0) {
            autoSaveToggle.setText("Auto-Save Scores (false)");
            System.out.println("save.saveClickerTimerAuto = false");;
        }

        saveConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        clickerRefer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/udu3324/clickerBoard/wiki/clickerBoard-Introduction"));
                    } catch (IOException | URISyntaxException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        autoSaveToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save.saveClickerTimerAuto == 1) {
                    save.saveClickerTimerAuto = 0;
                    autoSaveToggle.setText("Auto-Save Scores (false)");
                    System.out.println("save.saveClickerTimerAuto = false");
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
                }   else {
                    save.saveClickerTimerAuto = 1;
                    autoSaveToggle.setText("Auto-Save Scores (true)");
                    System.out.println("save.saveClickerTimerAuto = true");
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
            }
        });
        resetDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Because of clickerBoard using txt files, you have to manually delete it yourself.\n" +
                                "Close clickerBoard and delete clickerConfig.txt and clickerSaves.txt to delete.",
                        "ClickerBoard",
                        JOptionPane.INFORMATION_MESSAGE,
                        null);
            }
        });
    }
}
