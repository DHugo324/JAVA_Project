package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class functionPanel extends JPanel {
  private JButton addButton;
  private JButton refreshButton;

  public functionPanel() {
    setLayout(new GridBagLayout());
    setBackground(Color.DARK_GRAY);
    addButton = new JButton("new");
    refreshButton = new JButton("refresh");
    add(addButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
    add(refreshButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
  }

  private class MyEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == addButton) {
        // JOptonPane
      } else if (e.getSource() == refreshButton) {

      }
    }
  }
}
