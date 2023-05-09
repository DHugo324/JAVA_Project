package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ClassManagement extends JFrame {
    private JPanel topPanel;
    private JPanel mainPanel;

    public ClassManagement() {

        super("Class Management");
        setLayout(new GridBagLayout());
        ActionListener listener = new MyEventListener();

        topPanel = new topPanel();
        mainPanel = new mainPanel();

        add(topPanel,
                new GridBagConstraints(0, 0, 1, 3, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                        new Insets(1, 0, 5, 0), 0, 0));
        add(mainPanel,
                new GridBagConstraints(0, 3, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
    }

    private class MyEventListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
        }
    }
}
