package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class msgPanel extends JPanel {
  private JLabel user, date, msg;

  public msgPanel() { // with message id input?
    setLayout(new GridBagLayout());
    setOpaque(true);
    setBackground(Color.GRAY);
    user = new JLabel("user");
    msg = new JLabel("Message");
    date = new JLabel("date");
    add(user,
        new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
    add(msg,
        new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    add(date,
        new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
  }

  public void setUser(String user) {
    this.user.setText(user);
  }

  public void setMessage(String msg) {
    this.msg.setText(msg);
  }

  public void setDate(String date) {
    this.date.setText(date);
  }
}
