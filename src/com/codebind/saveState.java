package com.codebind;

import javax.swing.*;

public class saveState {

    //version format: #major.#minor.#patch [A]describe beta, alpha, patch, release, etc.
    public String version = "1.4.0 Beta";

    //clickerCounter
    public int count = 0;

    //clickerTimer
    public int count2 = 0;

    public Timer timer;
    public int delay = 0;
    public long duration = 10000;
    public long startTime = -1;
}
