package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.border.*;

public class BtnPanel extends JPanel {
  private final ArrayList<JButton> Btn = new ArrayList<JButton>();
  private final String[] BtnName = { "課程消息", "其他消息", "留言板" };
  private final int ButtonCnt = 3;

  public BtnPanel() {
    setLayout(new GridBagLayout());
    for (int i = 0; i < ButtonCnt; i++) {
      JButton btn = new JButton(BtnName[i]);
      add(btn, new GridBagConstraints(0, i, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
          new Insets(0, 0, 1, 0), 0, 0));
      Btn.add(btn);
    }
  }

  public ArrayList<JButton> getButton() {
    return Btn;
  }

}