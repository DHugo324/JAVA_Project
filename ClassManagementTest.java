package java2023.project;

import javax.swing.JFrame;

public class ClassManagementTest {
  public static void main(String[] args) {
    ClassManagement classmanagement = new ClassManagement(new user("工具人學系", "01057777", 1));
    classmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    classmanagement.setSize(600, 500);
    classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
    classmanagement.setVisible(true);
  }
}