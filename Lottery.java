package java2023.project;

import java.security.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Lottery extends JList<String> {
  private DefaultListModel<String> optionsListModel;

  public Lottery(DefaultListModel<String> listModel) {
    super(listModel);
    optionsListModel = listModel;
    setFont(new Font("Dialog", Font.BOLD, 16));
    setLayout(new GridBagLayout());
    setVisible(true);
  }

  public void addOption() {
    String input = JOptionPane.showInputDialog(this, "請輸入選項，若想新增多個選項以','分隔：");
    if (input != null && !input.trim().isEmpty()) {
      String[] options = input.split(",");
      for (String option : options) {
        String trimmedOption = option.trim();
        if (!trimmedOption.isEmpty()) {
          optionsListModel.addElement(trimmedOption);
        }
      }
    }
  }

  public void deleteOption() {
    int[] selectedIndices = getSelectedIndices();
    if (selectedIndices.length > 0) {
      for (int i = selectedIndices.length - 1; i >= 0; i--) {
        optionsListModel.removeElementAt(selectedIndices[i]);
      }
    }
  }

  public void drawLottery() {
    int numOptions = optionsListModel.getSize();
    if (numOptions > 0) {
      SecureRandom random = new SecureRandom();
      int selectedIndex = random.nextInt(numOptions);
      setSelectedIndex(selectedIndex);
      String selectedOption = optionsListModel.getElementAt(selectedIndex);
      JOptionPane.showMessageDialog(this, "抽中的選項是：" + selectedOption);
    } else {
      JOptionPane.showMessageDialog(this, "沒有可供抽選的選項。");
    }
  }
}
