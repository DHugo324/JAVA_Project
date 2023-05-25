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

public class LoginBoardMain extends JFrame{
    private JPanel loginBoard;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField accountText;
    private JTextField passwordText;
    public static void main(String[] args){
        LoginBoardMain loginBoard = new LoginBoardMain();
        loginBoard.setLocationRelativeTo(null);
        loginBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginBoard.setSize(600, 500);
        loginBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginBoard.setVisible(true);
    }
    public LoginBoardMain() {
        super("Login");
        setBackground(Color.PINK);
        setLayout(new GridBagLayout());
        ActionListener listener = new MyEventListener();

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel accountPanel = new JPanel(new GridLayout(2, 1));
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
    
        accountText = new JTextField();
        accountText.setPreferredSize(new Dimension(300, 35));
        passwordText = new JPasswordField();
        passwordText.setPreferredSize(new Dimension(300, 35));

        loginButton = new JButton("LOGIN");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.addActionListener(listener);
        
        registerButton = new JButton("REGISTER");
        registerButton.setPreferredSize(new Dimension(100, 30));
        registerButton.addActionListener(listener);
        btnPanel.add(registerButton);
        btnPanel.add(loginButton);

        ImageIcon imageIcon = new ImageIcon("image.png"); // 替換為您的圖片路徑
        Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        JLabel titleLabel = new JLabel("Y o u r C l a s s");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        titlePanel.add(imageLabel);
        titlePanel.add(titleLabel);
        JLabel accountLabel = new JLabel("Account:");
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        accountPanel.add(accountLabel);
        accountPanel.add(accountText);
    
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
        JLabel warning = new JLabel("If you didn't have an account yet, please register");
        warning.setFont(new Font("Arial", Font.PLAIN, 14));
        warning.setForeground(Color.RED);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10); // 設定元件間距
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titlePanel,gbc);
        gbc.gridy = 1;
        add(accountPanel, gbc);
    
        gbc.gridy = 2;
        add(passwordPanel, gbc);
    
        gbc.gridy = 3;
        add(btnPanel, gbc);

        gbc.gridy = 4;
        add(warning,gbc);
    }



    private class MyEventListener implements ActionListener {
        //private Login user = new Login(accountText.getText(),passwordText.getText());
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {
                JOptionPane.showMessageDialog(null,"Welcome to YourClass");
                dispose();
            }
            else if(e.getSource()==registerButton){
                dispose();
                RegisterBoardMain registerBoard = new RegisterBoardMain();
        
                registerBoard.setSize(600, 500);
                registerBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
                registerBoard.setVisible(true);
            }
        } 
    }
}
