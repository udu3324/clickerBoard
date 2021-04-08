package com.codebind;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class saveState {
    File obj = new File("clickerConfig.txt");
    Scanner s = new Scanner(obj);
    public String one = s.nextLine ();
    public String two = s.nextLine ();
    public String three = s.nextLine ();
    public String four = s.nextLine ();
    public String five = s.nextLine ();
    public String six = s.nextLine ();
    public String seven = s.nextLine ();
    public String eight = s.nextLine (); //toggle auto
    public String nine = s.nextLine ();
    public String ten = s.nextLine ();
    public String eleven = s.nextLine (); //duration
    public String twelve = s.nextLine ();

    //converter 1
    String convert = eight.replaceAll("([a-z])", "");
    String convert11 = convert.replaceAll("([A-Z])", "");
    String convert111 = convert11.replaceAll("([=])", "");
    String convert1111 = convert111.replaceAll("([ ])", "");
    int converted1 = Integer.parseInt(convert1111);

    //converter 2
    String conver = eleven.replaceAll("([a-z])", "");
    String convert22 = conver.replaceAll("([A-Z])", "");
    String convert222 = convert22.replaceAll("([=])", "");
    String convert2222 = convert222.replaceAll("([ ])", "");
    int converted2 = Integer.parseInt(convert2222);

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
    public long duration = converted2; //can be editable in config (can be editable)
    public long startTime = -1; //not editable or saved

    //clickerConfig 1 = true | 0 = false
    public int saveClickerTimerAuto = converted1; //can be editable in config (can be editable)

    public saveState() throws FileNotFoundException {
    }
}
