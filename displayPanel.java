package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java2023.project.msgPanel;

import java.util.*;

public class displayPanel extends JPanel {
  private Scrollbar scrollbar;
  private ArrayList<JPanel> msgs;

  public displayPanel() {
    setOpaque(true);
    setBackground(Color.WHITE);
    setLayout(new GridBagLayout());
    setSize(375, 250);
    int sz = 20;
    msgs = new ArrayList<JPanel>();
    for (int i = 0; i < sz; i++) {
      msgs.add(new msgPanel());
      add(msgs.get(i), new GridBagConstraints(0, i, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
          new Insets(2, 2, 2, 2), 0, 0));
    }
  }
}
