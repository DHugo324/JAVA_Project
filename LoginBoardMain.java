package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class LoginBoardMain extends JFrame{
    private JPanel loginBoard;
    public static void main(String[] args){
        LoginBoardMain loginBoard = new LoginBoardMain();
        
        loginBoard.setSize(600, 500);
        // classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginBoard.setVisible(true);
    }
    public LoginBoardMain() {
        super("Login");
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
    
        JPanel accountPanel = new JPanel(new GridLayout(2, 1));
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1));
    
        JTextField accountText = new JTextField();
        accountText.setPreferredSize(new Dimension(250, 25));
        JTextField passwordText = new JTextField();
        passwordText.setPreferredSize(new Dimension(250, 25));
        JButton loginButton = new JButton("LOGIN");
    
        JLabel accountLabel = new JLabel("Account:");
        accountPanel.add(accountLabel);
        accountPanel.add(accountText);
    
        JLabel passwordLabel = new JLabel("PassWord:");
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
    
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10); // 設定元件間距
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(accountPanel, gbc);
    
        gbc.gridy = 2;
        add(passwordPanel, gbc);
    
        gbc.gridy = 3;
        add(loginButton, gbc);
    }
}
