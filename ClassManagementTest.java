package java2023.project;

import javax.swing.JFrame;

public class ClassManagementTest {
  public static void main(String[] args) {
    ClassManagement classmanagement = new ClassManagement();
    classmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    classmanagement.setSize(600, 500);
    // classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
    classmanagement.setVisible(true);
  }
}