package com.ui2;

import com.codebind.saveState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class clickerConfigUI {
    public JPanel rootPanel;
    private JLabel versionLabel;
    private JLabel creditsLabel;
    private JButton saveConfig;
    private JComboBox comboBoxTime;
    private JButton autoSaveToggle;
    private JButton clickerRefer;

    public clickerConfigUI() {
        saveState save = new saveState(); //load

        //change version to current one in saveState
        versionLabel.setText("v" + save.version);

        saveConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clickerRefer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/udu3324/clickerBoard/wiki/clickerBoard-Introduction"));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (URISyntaxException uriSyntaxException) {
                        uriSyntaxException.printStackTrace();
                    }
                }
            }
        });
        autoSaveToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (save.saveClickerTimerAuto == 1) {
                    save.saveClickerTimerAuto = 0;
                    autoSaveToggle.setText("Auto-Save Scores (false)");
                    System.out.println("save.saveClickerTimerAuto = false");
                    //insert write
                }   else {
                    save.saveClickerTimerAuto = 1;
                    autoSaveToggle.setText("Auto-Save Scores (true)");
                    System.out.println("save.saveClickerTimerAuto = true");
                    //insert write
                }
            }
        });
    }
}
