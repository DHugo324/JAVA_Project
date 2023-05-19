package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class mainPanel extends JPanel {
  private ArrayList<JButton> Btn = new ArrayList<JButton>();
  private final int ButtonCnt;
  private BtnPanel BtnPanel;
  private functionPanel functionPanel;
  private displayPanel displayPanel;
  private JScrollPane scrollPane;

  public mainPanel() {
    setLayout(new GridBagLayout());

    BtnPanel = new BtnPanel();
    Btn = BtnPanel.getButton();
    ButtonCnt = Btn.size();
    setButton();

    Btn.get(0).setEnabled(false);
    functionPanel = new functionPanel();
    displayPanel = new displayPanel(0);
    scrollPane = new JScrollPane(displayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    add(BtnPanel, new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(functionPanel, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(scrollPane, new GridBagConstraints(1, 1, 1, 3, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
        new Insets(0, 0, 5, 0), 0, 0));
  }

  public void setButton() {
    ActionListener listener = new MyEventListener();
    for (int i = 0; i < ButtonCnt; i++) {
      JButton btn = Btn.get(i);
      btn.addActionListener(listener);
    }
  }

  public void setDisplay(int kind) {
    displayPanel = new displayPanel(kind);
    scrollPane.setViewportView(displayPanel);
  }

  private class MyEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < ButtonCnt; i++) {
        if (Btn.get(i) == e.getSource()) {
          Btn.get(i).setEnabled(false);
          setDisplay(i);
        } else
          Btn.get(i).setEnabled(true);
      }
    }
  }
}
