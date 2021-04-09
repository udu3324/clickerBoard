package com.codebind;

import javax.swing.*;
import com.ui2.*;

import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InterruptedException, FileNotFoundException {
        //create and write config and save
        {
            File myObj = new File("clickerConfig.txt");
            try {
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    //writer
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(myObj, true));
                        out.write("# clickerBoard is by _._#3324/udu3324. \n");
                        out.write("# use clickerConfig to edit values safer. \n");
                        out.write("# read docs if you need help editing values. \n");
                        out.write("# only do things like edit integers! file is sensitive.\n");
                        out.write("# if something wrong happens, delete the file and run clickerBoard again.\n");
                        out.write("\n");
                        out.write("# 1 = true | 0 = false \n");
                        out.write("saveClickerTimerAuto = 1 \n");
                        out.write("\n");
                        out.write("# duration is in milliseconds \n");
                        out.write("duration = 10000 \n");
                        out.write("\n");
                        out.write("clickerTimer High Score = 0 \n");
                        out.write("clickerCounter High Score = 0 \n");
                        out.write("\n");
                        out.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        {
            File myObj2 = new File("clickerSaves.txt");
            try {
                if (myObj2.createNewFile()) {
                    System.out.println("File created: " + myObj2.getName());
                    //writer
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(myObj2, true));
                        out.write("# clickerBoard is by _._#3324/udu3324. \n");
                        out.write("# this file is to see your automatically saved scores. \n");
                        out.write("# it is safe to edit, but editing scores is bad and mean >:( \n");
                        out.write("\n");
                        out.close();
                        System.out.println("Successfully wrote to the file." + "\nyou will only see this one time on startup, unless if you did something.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        saveState save = new saveState();

        System.out.println("Hello, World!");
        System.out.println("ClickerBoard v" + save.version + " by");
        System.out.println("           _        _____  _____  _____   ___ \n" +
                "          | |      |____ ||____ |/ __  \\ /   |\n" +
                " _   _  __| |_   _     / /    / /`' / /'/ /| |\n" +
                "| | | |/ _` | | | |    \\ \\    \\ \\  / / / /_| |\n" +
                "| |_| | (_| | |_| |.___/ /.___/ /./ /__\\___  |\n" +
                " \\__,_|\\__,_|\\__,_|\\____/ \\____/ \\_____/   |_/");
        System.out.println(" ");
        System.out.println("saveState loaded");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame startUI = new JFrame("startUI");
        startUI.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("logo.png")));
        startUI.setContentPane(new startUI() .rootPanel);
        startUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUI.pack();
        startUI.setLocationRelativeTo(null);
        startUI.setVisible(true);
        System.out.println("startUI loaded");

        //info dialog (please don't remove)
        Thread.sleep(500);
        JOptionPane.showMessageDialog(null,
                "Thank you for using ClickerBoard. (by udu3324) \n\n" +
                        "If you appreciate it a lot, contribute by donating or contributing to the code. \n" +
                        "(suggest new features, report program issues, creating pull requests, etc.) \n" +
                        "If you want to know more about ClickerBoard or how it works, go to the \n" +
                        "wiki page on the github repository.\n\n" +
                        "This is a Beta Tester Version.\n" +
                        "Please report all bugs and glitches!!!",
                "ClickerBoard",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }
}
