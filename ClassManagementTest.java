package java2023.project;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClassManagementTest {
  public static void main(String[] args) {
    String[] options = { "是", "否" };
    int result = JOptionPane.showOptionDialog(null, "是否選擇有權限的帳號？", "請選擇", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null, options, null);
    ClassManagement classmanagement;
    if (result == JOptionPane.YES_OPTION)
      classmanagement = new ClassManagement(new user("測試人員", "01057777", 0));
    else if (result == JOptionPane.NO_OPTION)
      classmanagement = new ClassManagement(new user("測試人員", "01056666", 1));
    else
      return;
    classmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    classmanagement.setSize(600, 500);
    classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
    classmanagement.setVisible(true);
  }
}