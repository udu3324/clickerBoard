package com.ui2;

import com.codebind.saveState;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class clickerConfigUI {
    public JPanel rootPanel;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JButton saveConfig;
    private JComboBox<String> comboBoxTime;
    private JButton autoSaveToggle;
    private JButton clickerRefer;
    private JButton resetDefaultButton;

    public clickerConfigUI() throws FileNotFoundException {
        saveState save = new saveState();
        versionLabel.setText("v" + save.version);
        SimpleDateFormat df = new SimpleDateFormat("mm:ss.SSS");

        //thank you, BryV1, for reporting a bug.
        System.out.println(save.duration);
        if (save.duration == 10000) {
            comboBoxTime.setSelectedIndex(0);
            System.out.println("comboBoxTime changed 0");
        }

        if (save.duration>=10001 && save.duration <=29999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration == 30000) {
            comboBoxTime.setSelectedIndex(1);
            System.out.println("comboBoxTime changed 1");
        }

        if (save.duration>=30001 && save.duration <=59999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration == 60000) {
            comboBoxTime.setSelectedIndex(2);
            System.out.println("comboBoxTime changed 2");
        }

        if (save.duration>=60001 && save.duration <=999999999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration>=5001 && save.duration <=9999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration == 5000) {
            comboBoxTime.setSelectedIndex(3);
            System.out.println("comboBoxTime changed 3");
        }

        if (save.duration>=3001 && save.duration <=4999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration == 3000) {
            comboBoxTime.setSelectedIndex(4);
            System.out.println("comboBoxTime changed 4");
        }

        if (save.duration>=1001 && save.duration <=2999) {
            comboBoxTime.addItem("Custom Time: " + df.format(save.duration));
            comboBoxTime.setSelectedIndex(6);
            System.out.println("comboBoxTime changed to custom #");
        }

        if (save.duration == 1000) {
            comboBoxTime.setSelectedIndex(5);
            System.out.println("comboBoxTime changed 5");
        }



        //change auto save label to right one in config
        if (save.saveClickerTimerAuto == 1) {
            autoSaveToggle.setText("Auto-Save Scores (true)");
            System.out.println("save.saveClickerTimerAuto = true");
        }
        if (save.saveClickerTimerAuto == 0) {
            autoSaveToggle.setText("Auto-Save Scores (false)");
            System.out.println("save.saveClickerTimerAuto = false");
        }

        saveConfig.addActionListener(e -> System.exit(0));
        clickerRefer.addActionListener(e -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/udu3324/clickerBoard/wiki"));
                } catch (IOException | URISyntaxException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        autoSaveToggle.addActionListener(e -> {
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
            JOptionPane.showMessageDialog(null,
                    "The Config has noticed a change. Make sure to press the Save Config and Restart button to save Config.",
                    "Save Warning",
                    JOptionPane.WARNING_MESSAGE);
        });
        resetDefaultButton.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Because of clickerBoard using txt files, you have to manually delete it yourself.\n" +
                        "Close clickerBoard and delete clickerConfig.txt and clickerSaves.txt to delete.",
                "ClickerBoard",
                JOptionPane.INFORMATION_MESSAGE,
                null));
        comboBoxTime.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "The Config has noticed a change. Make sure to press the Save Config and Restart button to save Config.",
                    "Save Warning",
                    JOptionPane.WARNING_MESSAGE);
            String one = "Time Duration: 00:10.000 10s (default)";
            String two = "Time Duration: 00:30.000 30s";
            String three = "Time Duration: 01:00.000 1m";
            String four = "Time Duration: 00:05.000 5s";
            String five = "Time Duration: 00:03.000 3s";
            String six = "Time Duration: 00:01.000 1s";

            System.out.println("change happened");

            if (comboBoxTime.getSelectedItem() == one) {
                System.out.println("selected 1");
                save.duration = 10000;
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
            if (comboBoxTime.getSelectedItem() == two) {
                System.out.println("selected 2");
                save.duration = 30000;
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
            if (comboBoxTime.getSelectedItem() == three) {
                System.out.println("selected 3");
                save.duration = 60000;
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
            if (comboBoxTime.getSelectedItem() == four) {
                System.out.println("selected 4");
                save.duration = 5000;
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
            if (comboBoxTime.getSelectedItem() == five) {
                System.out.println("selected 5");
                save.duration = 3000;
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
            if (comboBoxTime.getSelectedItem() == six) {
                System.out.println("selected 6");
                save.duration = 1000;
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
        });
    }
}
