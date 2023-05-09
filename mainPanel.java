package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class mainPanel extends JPanel {
  private JPanel BtnPanel;
  private JPanel displayPanel;
  private JScrollPane scrollPane;

  public mainPanel() {
    setLayout(new GridBagLayout());

    BtnPanel = new BtnPanel();

    displayPanel = new displayPanel();
    scrollPane = new JScrollPane(displayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    add(BtnPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(scrollPane, new GridBagConstraints(1, 0, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(5, 0, 5, 0), 0, 0));
  }
}
