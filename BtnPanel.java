package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class BtnPanel extends JPanel {
  private JButton Btn1;
  private JButton Btn2;
  private JButton Btn3;

  public BtnPanel() {
    setLayout(new GridBagLayout());

    Btn1 = new JButton("按鈕1");
    Btn2 = new JButton("按鈕2");
    Btn3 = new JButton("按鈕3");

    add(Btn1, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));
    add(Btn2, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));
    add(Btn3, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));
  }
}