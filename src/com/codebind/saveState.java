package com.codebind;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class saveState {
    File obj = new File("clickerConfig.txt");
    Scanner s;
    {
        try {
            s = new Scanner(obj);
            String one = s.nextLine ();
            String two = s.nextLine ();
            String three = s.nextLine ();
            String four = s.nextLine ();
            String five = s.nextLine ();
            String six = s.nextLine ();
            String seven = s.nextLine ();
            String eight = s.nextLine ();
            String nine = s.nextLine ();
            String ten = s.nextLine ();
            String eleven = s.nextLine ();
            String twelve = s.nextLine ();
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //these are default values. please do not edit them.
    //version format: #major.#minor.#very minor or patch [A]describe beta, beta test, alpha, patch, release, etc.
    public String version = "0.8.2 Beta-Test"; //not saving value or editable

    //clickerCounter
    public int count = 0;  //not editable or saved
    public int highestCount0 = 0; //saves in save but not editable (can be toggled)

    //clickerTimer
    public int count2 = 0; //not editable or saved
    public int highestCount = 0; //saves in save but not editable (can be toggled)

    public Timer timer;
    public long duration = 10000; //can be editable in config (can be editable)
    public long startTime = -1; //not editable or saved

    //clickerConfig
    //1 = true | 0 = false
    //this saves auto highercount into save txt
    public int saveClickerTimerAuto = 1; //can be editable in config (can be editable)
}
