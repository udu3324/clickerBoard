package com.codebind;

import javax.swing.*;
import com.ui2.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InterruptedException {
        //create config and save
        {
            File myObj = new File("clickerConfig.txt");
            try {
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        {
            File myObj2 = new File("clickerSaves.txt");
            try {
                if (myObj2.createNewFile()) {
                    System.out.println("File created: " + myObj2.getName() + "\nyou will only see this one time on startup, unless if you did something.");
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
                "Thank you for using ClickerBoard. (by udu3324) \n\nIf you appreciate it a lot, contribute by donating or contributing to the code. \n(suggest new features, report program issues, creating pull requests, etc.) \nIf you want to know more about ClickerBoard or how it works, go to the \nwiki page on the github repository.\n\nThis is a Beta Tester Version.\nPlease report all bugs and glitches!!!",
                "ClickerBoard",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }
}
