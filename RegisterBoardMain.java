package java2023.project;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.Timer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class RegisterBoardMain extends JFrame {
    private RegisterBoardMain registerBoard;
    private JButton registerButton;
    private JButton backButton;
    private JTextField newAccountText;
    private JTextField newPassWordText;
    private JTextField newAuthorization;
    private JComboBox<String> cNuComboBox, gNuComboBox, dComboBox;

    public static void main(String[] args) {
        RegisterBoardMain registerBoard = new RegisterBoardMain();
        Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) sz.getWidth() / 2;
        int h = (int) sz.getHeight() / 2;
        registerBoard.setSize(900, 750);
        registerBoard.setLocation(w - 450, h - 375);
        registerBoard.setVisible(true);
    }

    public RegisterBoardMain() {
        super("Register");
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        ActionListener listener = new MyEventListener();

        final String[] department = { "請選擇", "電機工程學系", "資訊工程學系", "通訊與導航工程學系", "光電與材料科技學系" };
        final String[] classNum = { "請選擇", "A", "B", "C", "D", "E", "F", "G" };
        final String[] gradeNum = { "請選擇", "1", "2", "3", "4" };
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel otherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel accountPanel = new JPanel(new GridLayout(2, 1));
        JPanel passWordPanel = new JPanel(new GridLayout(2, 1));
        JPanel pwTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel athPanel = new JPanel(new GridLayout(2, 1));
        JPanel departPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel btnPanel = new JPanel(new GridLayout(1, 3));

        JLabel classLabel = new JLabel("Class:");
        classLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel dLabel = new JLabel("Major:");
        dLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        cNuComboBox = new JComboBox<>(classNum);
        cNuComboBox.setPreferredSize(new Dimension(80, 30));
        gNuComboBox = new JComboBox<>(gradeNum);
        gNuComboBox.setPreferredSize(new Dimension(80, 30));
        dComboBox = new JComboBox<>(department);
        dComboBox.setPreferredSize(new Dimension(230, 30));
        departPanel.add(dLabel);
        departPanel.add(dComboBox);
        otherPanel.add(gradeLabel);
        otherPanel.add(gNuComboBox);
        otherPanel.add(classLabel);
        otherPanel.add(cNuComboBox);

        newAccountText = new JTextField();
        newAccountText.setPreferredSize(new Dimension(300, 30));
        newPassWordText = new JPasswordField();
        newPassWordText.setPreferredSize(new Dimension(300, 30));
        newAuthorization = new JTextField("如果沒有擔任幹部可跳過");
        newAuthorization.setPreferredSize(new Dimension(300, 30));

        registerButton = new JButton("REGISTER");
        registerButton.setPreferredSize(new Dimension(100, 30));
        registerButton.addActionListener(listener);
        backButton = new JButton("Back to Login");
        backButton.setPreferredSize(new Dimension(115, 30));
        backButton.addActionListener(listener);

        ImageIcon imageIcon = new ImageIcon("image.png"); // 替換為您的圖片路徑
        Image image = imageIcon.getImage().getScaledInstance(130, 165, Image.SCALE_SMOOTH);
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
        pwTextPanel.add(passWordLabel);
        passWordPanel.add(pwTextPanel);
        passWordPanel.add(newPassWordText);

        JLabel authorizationLabel = new JLabel("Authorization code:");
        authorizationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        athPanel.add(authorizationLabel);
        athPanel.add(newAuthorization);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10); // 設定元件間距
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(titlePanel, gbc);

        gbc.gridy = 1;
        add(departPanel, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 2;
        add(otherPanel, gbc);
        gbc.gridy = 3;
        add(accountPanel, gbc);

        gbc.gridy = 4;
        add(passWordPanel, gbc);

        gbc.gridy = 5;
        add(athPanel, gbc);

        btnPanel.add(backButton);
        btnPanel.add(registerButton);
        gbc.gridy = 6;
        add(btnPanel, gbc);

    }

    public static boolean validatePassword(String password) {
        // 正則表達式，至少包含一個小寫字母、一個大寫字母和一個數字
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        // 使用正則表達式進行驗證
        return matcher.matches();
    }

    public static void tryAgain(String name, String passwd) {
        JFrame welcome = new JFrame("Error!!!");
        JLabel hi;
        if (name.isEmpty() || passwd.isEmpty()) {
            hi = new JLabel("Name or Password can't be empty!!!");
        } else if (validatePassword(passwd) == false) {
            hi = new JLabel(
                    "<html>Password must contain at least<br>one uppercase letter,lowercase letter and digit!</html>");
        } else if (passwd.length() < 6) {
            hi = new JLabel("The password must have at least six characters!");
        } else {
            hi = new JLabel("Duplicate Account,please try again!");
        }
        hi.setForeground(Color.RED);
        Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) sz.getWidth() / 2;
        int h = (int) sz.getHeight() / 2;
        hi.setHorizontalAlignment(SwingConstants.LEFT); // 將文字置中
        hi.setFont(new Font("Arial", Font.PLAIN, 14));
        welcome.setBackground(Color.WHITE);
        welcome.setSize(450, 225);
        welcome.setLocation(w - 225, h - 113);
        welcome.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH; // 使用所有可用空間
        gbc.insets = new Insets(10, 10, 10, 10); // 設定間距

        welcome.add(hi, gbc);

        welcome.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(2500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.dispose(); // 延遲 1.2 秒後關閉視窗
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private class MyEventListener implements ActionListener {
        private Register register = null;

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == registerButton) {
                user user;
                if (newAuthorization.getText().equals("ntouAccess"))
                    user = new user(dComboBox.getSelectedItem().toString(), newAccountText.getText(), 0);
                else
                    user = new user(dComboBox.getSelectedItem().toString(), newAccountText.getText(), 1);
                register = new Register(user, newAccountText.getText(), newPassWordText.getText());
                if (register.insertTable() == 1) {
                    dispose();
                    JFrame welcome = new JFrame("You did it!");
                    JLabel hi = new JLabel("<html>Registered successfully<br>(ゝ∀･)b</html>");
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
                    javax.swing.Timer timer = new javax.swing.Timer(2200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            welcome.dispose(); // 延遲 1.2 秒後關閉視窗
                            LoginBoardMain loginBoard = new LoginBoardMain();
                            loginBoard.setSize(600, 500);
                            loginBoard.setLocation(w - 300, h - 250);
                            loginBoard.setVisible(true);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                }

                else {
                    System.out.printf("FUCK!!!%n");
                }
            } else if (e.getSource() == backButton) {
                dispose();
                LoginBoardMain loginBoard = new LoginBoardMain();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int centerX = screenSize.width / 2;
                int centerY = screenSize.height / 2;

                loginBoard.setSize(600, 500);
                loginBoard.setLocation(centerX - 300, centerY - 250);
                loginBoard.setVisible(true);
            }
        }
    }
}
