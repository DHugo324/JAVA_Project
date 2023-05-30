package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ClassManagement extends JFrame {
        private JPanel topPanel;
        private JPanel mainPanel;
        private user user;
        private JButton logoutBtn;

        public ClassManagement(user user) {
                super("Class Management");
                setLayout(new GridBagLayout());

                this.user = user;

                logoutBtn = new JButton("登出");
                logoutBtn.addActionListener(new MyEventListener());
                topPanel = new topPanel(user, logoutBtn);
                mainPanel = new mainPanel(user);

                add(topPanel,
                                new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTH,
                                                GridBagConstraints.BOTH,
                                                new Insets(0, 0, 0, 0), 0, 0));
                add(mainPanel,
                                new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
                                                GridBagConstraints.BOTH,
                                                new Insets(0, 0, 0, 0), 0, 0));
        }

        private class MyEventListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == logoutBtn) {
                                LoginBoardMain loginBoard = new LoginBoardMain();
                                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                int centerX = screenSize.width / 2;
                                int centerY = screenSize.height / 2;

                                loginBoard.setSize(600, 500);
                                loginBoard.setLocation(centerX - 300, centerY - 250);
                                loginBoard.setVisible(true);
                                loginBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                dispose();
                        }
                }
        }
}
