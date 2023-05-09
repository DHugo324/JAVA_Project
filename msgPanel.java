package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class msgPanel extends JPanel {
  private JLabel msg;

  public msgPanel() { // with message id input?
    setOpaque(true);
    setBackground(Color.GRAY);
    msg = new JLabel("Message");
    add(msg);
  }
}
