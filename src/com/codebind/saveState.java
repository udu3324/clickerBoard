package com.codebind;

import javax.swing.*;

public class saveState {

    //these are default values. please do not edit them.
    //version format: #major.#minor.#very minor or patch [A]describe beta, beta test, alpha, patch, release, etc.
    public String version = "0.8.2 Beta-Test"; //not saving value or editable

    //clickerCounter
    public int count = 0;  //not editable or saved
    public int highestCount0 = 0; //saves in save but not editable

    //clickerTimer
    public int count2 = 0; //not editable or saved
    public int highestCount = 0; //saves in save but not editable

    public Timer timer;
    public long duration = 10000; //can be editable in config
    public long startTime = -1; //not editable or saved
}
