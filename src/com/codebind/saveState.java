package com.codebind;

import javax.swing.*;

public class saveState {
    //version
    //format: #major.#minor.#patch [A]describe beta, alpha, patch, release, etc.
    public String version = "1.3.0 Beta";

    //clickerCounter
    public int count = 0;

    //clickerTimer
    //timer stuff
    public final Timer timer; //create timer
    public int delay = 300; //delay of when the time starts
    public long duration = 10000; //duration of time
    public long startTime = -1; //start of the time (do not remove)
}
