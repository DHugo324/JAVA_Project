package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java2023.project.BoardWrite;

import java.util.*;

public class mainPanel extends JPanel {
  private ArrayList<JButton> Btn = new ArrayList<JButton>();
  private final int ButtonCnt;
  private BtnPanel BtnPanel;
  private JPanel functionPanel;
  private displayPanel displayPanel;
  private JScrollPane scrollPane;
  private JButton addButton;
  private JButton refreshButton;

  public mainPanel() {
    setLayout(new GridBagLayout());

    BtnPanel = new BtnPanel();
    Btn = BtnPanel.getButton();
    ButtonCnt = Btn.size();
    setButton();

    Btn.get(0).setEnabled(false);
    functionPanel = new JPanel();
    setFunctionPanel();
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

  private void setFunctionPanel() {
    functionPanel.setLayout(new GridBagLayout());
    functionPanel.setBackground(Color.DARK_GRAY);
    addButton = new JButton("new");
    refreshButton = new JButton("refresh");
    addButton.addActionListener(new MyEventListener());
    refreshButton.addActionListener(new MyEventListener());
    functionPanel
        .add(addButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
    functionPanel
        .add(refreshButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
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

  public void addMessage(int kind) {
    // addPanel
    if (kind == 0) {
      BoardWriter BoardWriter = new BoardWriter(0);
    } else if (kind == 1) {
      BoardWriter BoardWriter = new BoardWriter(1);
    } else {
      BoardWriter BoardWriter = new BoardWriter(2);
    }
  }

  private class MyEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == addButton) {
        for (int i = 0; i < ButtonCnt; i++) {
          if (Btn.get(i).isEnabled() == false) {
            addMessage(i);
            break;
          }
        }
        JOptionPane pane = new JOptionPane("Success");
        pane.showMessageDialog(null, "新增成功，若未成功顯示，請重新整理。");
      } else if (e.getSource() == refreshButton) {
        for (int i = 0; i < ButtonCnt; i++) {
          if (Btn.get(i).isEnabled() == false) {
            setDisplay(i);
            break;
          }
        }
      } else {
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
}
