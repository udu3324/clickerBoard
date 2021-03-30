package com.codebind;

import javax.swing.*;
import com.ui2.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        saveState save = new saveState(); //load

        System.out.println("Hello, World!");
        System.out.println("ClickerBoard v" + save.version + " by");
        System.out.println("           _        _____  _____  _____   ___ \n" +
                "          | |      |____ ||____ |/ __  \\ /   |\n" +
                " _   _  __| |_   _     / /    / /`' / /'/ /| |\n" +
                "| | | |/ _` | | | |    \\ \\    \\ \\  / / / /_| |\n" +
                "| |_| | (_| | |_| |.___/ /.___/ /./ /__\\___  |\n" +
                " \\__,_|\\__,_|\\__,_|\\____/ \\____/ \\_____/   |_/");
        System.out.println(" ");


        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        System.out.println("saveState loaded");
        System.out.println("startUI loaded");
        //startUI start
        JFrame startUI = new JFrame("startUI");
        startUI.setContentPane(new startUI() .rootPanel);
        startUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUI.pack();
        startUI.setLocationRelativeTo(null);
        startUI.setVisible(true);

        //info dialog (please don't remove)
        JOptionPane.showMessageDialog(null,
                "Thank you for using ClickerBoard. (by udu3324) \n\nIf you appreciate it a lot, contribute by donating or contributing to the code. \n(suggest new features, report program issues, creating pull requests, etc.) \nIf you want to know more about ClickerBoard or how it works, go to the \nwiki page on the github repository.",
                "ClickerBoard",
                JOptionPane.INFORMATION_MESSAGE,
                null);
    }
}
