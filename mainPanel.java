package java2023.project;

import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class mainPanel extends JPanel {
  private ArrayList<JButton> Btn = new ArrayList<JButton>();
  private final int ButtonCnt;
  private BtnPanel BtnPanel;
  private JPanel functionPanel;
  private JPanel displayPanel;
  private JScrollPane scrollPane;
  private JComboBox<String> idChooser;
  private JButton newButton;
  private JButton addButton;
  private JButton refreshButton;
  private JButton deleteButton;
  private JButton drawButton;
  private Lottery lottery;
  private DefaultListModel<String> optionsListModel;
  private user user;

  public mainPanel(user user) {
    setLayout(new GridBagLayout());

    this.user = user;

    BtnPanel = new BtnPanel();
    Btn = BtnPanel.getButton();
    ButtonCnt = Btn.size();
    setButton();

    Btn.get(0).setEnabled(false);

    addFunction();
    optionsListModel = new DefaultListModel<>();
    lottery = new Lottery(optionsListModel);
    functionPanel = new JPanel();
    setFunctionPanel(0);
    scrollPane = new JScrollPane(displayPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    setDisplay(0);

    add(BtnPanel, new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(functionPanel, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
        new Insets(5, 0, 0, 0), 0, 0));
    add(scrollPane, new GridBagConstraints(1, 1, 1, 3, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
        new Insets(0, 0, 5, 0), 0, 0));
  }

  private void addFunction() {
    idChooser = new JComboBox<String>();
    idChooser.addItem(user.getID());
    idChooser.addItem(user.getMajor());
    idChooser.addItem("匿名");
    idChooser.setEditable(false);
    newButton = new JButton("新增");
    refreshButton = new JButton("重新整理");
    newButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ButtonCnt; i++) {
          if (Btn.get(i).isEnabled() == false) {
            addMessage(i);
            break;
          }
        }
      }
    });
    refreshButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ButtonCnt; i++) {
          if (Btn.get(i).isEnabled() == false) {
            setDisplay(i);
            break;
          }
        }
      }
    });

    addButton = new JButton("新增");
    deleteButton = new JButton("刪除");
    drawButton = new JButton("抽籤");
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        lottery.addOption();
      }
    });
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        lottery.deleteOption();
      }
    });
    drawButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        lottery.drawLottery();
      }
    });
  }

  private void setFunctionPanel(int kind) {
    if (kind >= 0 && kind <= 2) {
      functionPanel.remove(addButton);
      functionPanel.remove(deleteButton);
      functionPanel.remove(drawButton);

      functionPanel.setLayout(new GridBagLayout());
      functionPanel.setBackground(Color.DARK_GRAY);
      if (kind == 2) {
        idChooser.setVisible(true);
        newButton.setEnabled(true);
      } else {
        idChooser.setVisible(false);
        if (user.getAccess() != 0)
          newButton.setEnabled(false);
        else // 有管理權限
          newButton.setEnabled(true);
      }
      functionPanel.add(idChooser,
          new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
      functionPanel
          .add(newButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
      functionPanel
          .add(refreshButton, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
    } else {
      functionPanel.remove(idChooser);
      functionPanel.remove(newButton);
      functionPanel.remove(refreshButton);

      functionPanel.add(addButton,
          new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
      functionPanel.add(deleteButton,
          new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
      functionPanel.add(drawButton,
          new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
              new Insets(0, 0, 0, 0), 0, 0));
    }
    functionPanel.revalidate();
    functionPanel.repaint();
  }

  public void setButton() {
    ActionListener listener = new MyEventListener();
    for (int i = 0; i < ButtonCnt; i++) {
      JButton btn = Btn.get(i);
      btn.addActionListener(listener);
    }
  }

  public void setDisplay(int kind) {
    if (kind >= 0 && kind <= 2) {
      displayPanel = new displayPanel(kind);
      scrollPane.setViewportView(displayPanel);
    } else if (kind == 3) {
      scrollPane.setViewportView(lottery);
    }
  }

  public void addMessage(int kind) {
    BoardWriter BoardWriter = new BoardWriter(kind);
    String text = JOptionPane.showInputDialog(null, "請輸入想新增的內容：", "", JOptionPane.PLAIN_MESSAGE);
    if (text == null || text.isEmpty()) {
      JOptionPane.showMessageDialog(null, "新增失敗", "Failed", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    if (kind == 3) {
      BoardWriter.addMessage(idChooser.getSelectedItem().toString(),
          new SimpleDateFormat("yyyy-MM-dd").format(new Date()), text);
    } else {
      BoardWriter.addMessage(user.getID(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()), text);
    }
    ImageIcon icon = new ImageIcon("check.png", "success");
    JOptionPane.showMessageDialog(null, "新增成功，若未成功顯示，請重新整理。", "Successful", JOptionPane.INFORMATION_MESSAGE, icon);
  }

  private class MyEventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < ButtonCnt; i++) {
        if (Btn.get(i) == e.getSource()) {
          Btn.get(i).setEnabled(false);
          setDisplay(i);
          setFunctionPanel(i);
        } else
          Btn.get(i).setEnabled(true);
      }
    }
  }
}
