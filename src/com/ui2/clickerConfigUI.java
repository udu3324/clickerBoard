package com.ui2;

import com.codebind.saveState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickerConfigUI {
    public JPanel rootPanel;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JButton settingInfoButton;

    public clickerConfigUI() {
        saveState save = new saveState(); //load

        //change version to current one in saveState
        versionLabel.setText("v" + save.version);

    }
}
