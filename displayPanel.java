package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java2023.project.BoardRead;

import java.util.*;

public class displayPanel extends JPanel {
  private ArrayList<JPanel> msgPanels = new ArrayList<JPanel>();

  public displayPanel(int showKind) {
    setOpaque(true);
    setBackground(Color.WHITE);
    setLayout(new GridBagLayout());
    show(showKind);
  }

  public void show(int kind) {
    ArrayList<msg> msgs = new ArrayList<msg>();
    BoardReader boardReader = new BoardReader(kind);
    msgs = boardReader.getMessages();
    int sz = msgs.size();
    for (int i = 0; i < sz; i++) {
      msgPanel nowMsgPanel = new msgPanel();
      msg msg = msgs.get(i);
      nowMsgPanel.setUser(msg.getUser());
      msgPanels.add(nowMsgPanel);
      add(msgPanels.get(i),
          new GridBagConstraints(0, i, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
              new Insets(2, 2, 2, 2), 0, 0));

    }
  }
}
