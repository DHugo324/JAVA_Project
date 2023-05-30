package java2023.project;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class LoginBoardMain extends JFrame {
    private JPanel loginBoard;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField accountText;
    private JTextField passwordText;

    public static void main(String[] args) {
        LoginBoardMain loginBoard = new LoginBoardMain();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        loginBoard.setSize(600, 500);
        loginBoard.setLocation(centerX - 300, centerY - 250);
        loginBoard.setVisible(true);
        loginBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LoginBoardMain() {
        super("Login");
        setBackground(Color.PINK);
        setLayout(new GridBagLayout());
        ActionListener listener = new MyEventListener();

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel accountPanel = new JPanel(new GridLayout(2, 1));
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));

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
        add(titlePanel, gbc);
        gbc.gridy = 1;
        add(accountPanel, gbc);

        gbc.gridy = 2;
        add(passwordPanel, gbc);

        gbc.gridy = 3;
        add(btnPanel, gbc);

        gbc.gridy = 4;
        add(warning, gbc);
    }

    private class MyEventListener implements ActionListener {
        private Login user;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginButton) {
                user = new Login(accountText.getText(), passwordText.getText());
                if (user.selectTable() == 1) {
                    JFrame welcome = new JFrame("Enjoying Everyday");
                    JLabel hi = new JLabel("<html>Welcome to YourClass<br>(“￣▽￣)-o█ █o-(￣▽￣”)/</html>");
                    Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
                    int w = (int) sz.getWidth() / 2;
                    int h = (int) sz.getHeight() / 2;
                    hi.setHorizontalAlignment(SwingConstants.CENTER); // 將文字置中

                    welcome.setBackground(Color.WHITE);
                    welcome.setSize(300, 150);
                    welcome.setLocation(w - 150, h - 75);
                    welcome.setLayout(new GridBagLayout());

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.fill = GridBagConstraints.BOTH; // 使用所有可用空間
                    gbc.insets = new Insets(10, 10, 10, 10); // 設定間距

                    welcome.add(hi, gbc);

                    welcome.setVisible(true);
                    dispose();
                    javax.swing.Timer timer = new javax.swing.Timer(1500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            welcome.dispose(); // 延遲 1.5 秒後關閉視窗
                            ClassManagement classmanagement = new ClassManagement(user.getUser());
                            classmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            classmanagement.setSize(600, 500);
                            classmanagement.setLocation(w - 300, h - 250);
                            // classmanagement.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            classmanagement.setVisible(true);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Accont or Password!!!\nPlease try again!");
                }
            } else if (e.getSource() == registerButton) {
                dispose();
                RegisterBoardMain registerBoard = new RegisterBoardMain();
                Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
                int w = (int) sz.getWidth() / 2;
                int h = (int) sz.getHeight() / 2;
                registerBoard.setSize(900, 750);
                registerBoard.setLocation(w - 450, h - 375);
                registerBoard.setVisible(true);
                registerBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }
}
