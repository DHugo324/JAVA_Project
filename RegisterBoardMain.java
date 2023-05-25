package java2023.project;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import loginSystem.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class RegisterBoardMain extends JFrame{
    private JPanel registerBoard;
    private JButton registerButton;
    private JTextField newAccountText;
    private JTextField newPassWordText;
    public static void main(String[] args){
        RegisterBoardMain registerBoard = new RegisterBoardMain();
        
        registerBoard.setSize(600, 500);
        // classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registerBoard.setVisible(true);
    }
    public RegisterBoardMain() {
        super("Register");
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        ActionListener listener = new MyEventListener();

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel accountPanel = new JPanel(new GridLayout(2, 1));
        JPanel passWordPanel = new JPanel(new GridLayout(2, 1));
    
        newAccountText = new JTextField();
        newAccountText.setPreferredSize(new Dimension(250, 25));
        newPassWordText = new JPasswordField();
        newPassWordText.setPreferredSize(new Dimension(250, 25));

        registerButton = new JButton("REGISTER");
        registerButton.addActionListener(listener);
        
        ImageIcon imageIcon = new ImageIcon("image.png"); // 替換為您的圖片路徑
        Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel titleLabel = new JLabel("Y o u r C l a s s");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        titlePanel.add(imageLabel);
        titlePanel.add(titleLabel);
        JLabel accountLabel = new JLabel("New Account:");
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        accountPanel.add(accountLabel);
        accountPanel.add(newAccountText);
    
        JLabel passWordLabel = new JLabel("PassWord:");
        passWordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passWordPanel.add(passWordLabel);
        passWordPanel.add(newPassWordText);
    
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 5, 10); // 設定元件間距
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titlePanel,gbc);
        gbc.gridy = 1;
        add(accountPanel, gbc);
    
        gbc.gridy = 2;
        add(passWordPanel, gbc);
    
        gbc.gridy = 3;
        add(registerButton, gbc);
    }



    private class MyEventListener implements ActionListener {
        //private Login user = new Login(accountText.getText(),passwordText.getText());
        private JTextField t = new JTextField();
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registerButton) {
                dispose();
                LoginBoardMain loginBoard = new LoginBoardMain();
                loginBoard.setSize(600, 500);
                // classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
                loginBoard.setVisible(true);
            }
        } 
    }
}
