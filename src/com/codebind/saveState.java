package com.codebind;

import javax.swing.*;

public class saveState {

    //version format: #major.#minor.#patch [A]describe beta, alpha, patch, release, etc.
    public String version = "1.7.1 Beta";

    //clickerCounter
    public int count = 0;
    public int highestCount0 = 0;

    //clickerTimer
    public int count2 = 0;
    public int highestCount = 0;

    public Timer timer;
    public long duration = 10000;
    public long startTime = -1;
}
