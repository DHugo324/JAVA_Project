package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class topPanel extends JPanel {
  private JLabel titleLable;
  private JButton logoutBtn;

  public topPanel() {
    setLayout(new GridBagLayout());

    titleLable = new JLabel("班級管理系統");
    titleLable.setOpaque(true);
    titleLable.setBackground(Color.WHITE);
    logoutBtn = new JButton("登出");
    logoutBtn.addActionListener(new MyEventListener());

    add(titleLable,
        new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    add(logoutBtn,
        new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
  }

  private class MyEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == logoutBtn) {
        System.exit(1);
      }
    }
  }
}