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

                topPanel = new topPanel();
                mainPanel = new mainPanel();

                add(topPanel,
                                new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH,
                                                GridBagConstraints.BOTH,
                                                new Insets(1, 0, 5, 0), 0, 0));
                add(mainPanel,
                                new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                                                GridBagConstraints.BOTH,
                                                new Insets(0, 0, 5, 0), 0, 0));
        }
}
