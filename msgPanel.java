package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class msgPanel extends JPanel {
  private JLabel user, date, context;

  public msgPanel(msg msg) { // with message id input?
    setLayout(new GridBagLayout());
    setOpaque(true);
    setBackground(Color.GRAY);
    this.user = new JLabel(msg.getUser());
    this.context = new JLabel(msg.getMessage());
    this.date = new JLabel(msg.getDate());
    add(this.user,
        new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
    add(this.context,
        new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    add(this.date,
        new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
  }

  public void setUser(String user) {
    this.user.setText(user);
  }

  public void setMessage(String msg) {
    this.context.setText(msg);
  }

  public void setDate(String date) {
    this.date.setText(date);
  }
}
