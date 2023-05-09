package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class mainPanel extends JPanel {
  private JPanel BtnPanel;
  private JLabel displayBox;

  public mainPanel() {
    setLayout(new GridBagLayout());
    BtnPanel = new BtnPanel();

    displayBox = new JLabel("資訊顯示處", JLabel.CENTER);
    displayBox.setOpaque(true);
    displayBox.setBackground(Color.WHITE);

    add(BtnPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(displayBox, new GridBagConstraints(1, 0, 50, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(5, 0, 5, 0), 0, 0));
  }
}
