package java2023.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ClassManagement extends JFrame {
  private JLabel titleLable;
  private JButton logoutBtn;
  private ButtonGroup menu;
  private JButton Btn1;
  private JButton Btn2;
  private JButton Btn3;
  private JLabel displayBox;
  private JPanel topPanel;
  private JPanel mainPanel;
  private JPanel BtnPanel;

  public ClassManagement() {

    super("Class Management");
    setLayout(new GridBagLayout());
    ActionListener listener = new MyEventListener();

    topPanel = new JPanel(new GridBagLayout());
    titleLable = new JLabel("班級管理系統");
    titleLable.setOpaque(true);
    titleLable.setBackground(Color.WHITE);
    topPanel.add(titleLable,
        new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
    logoutBtn = new JButton("登出");
    topPanel.add(logoutBtn,
        new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

    BtnPanel = new JPanel(new GridBagLayout());
    Btn1 = new JButton("按鈕1");
    BtnPanel.add(Btn1, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));
    Btn2 = new JButton("按鈕2");
    BtnPanel.add(Btn2, new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));
    Btn3 = new JButton("按鈕3");
    BtnPanel.add(Btn3, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 0), 0, 0));

    displayBox = new JLabel("資訊顯示處", JLabel.CENTER);
    displayBox.setOpaque(true);
    displayBox.setBackground(Color.WHITE);

    mainPanel = new JPanel(new GridBagLayout());
    mainPanel.add(BtnPanel,
        new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(5, 0, 0, 0), 0, 0));
    mainPanel.add(displayBox, new GridBagConstraints(1, 0, 50, 3, 1, 1, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH,
        new Insets(5, 0, 5, 0), 0, 0));

    add(topPanel,
        new GridBagConstraints(0, 0, 1, 3, 1, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
            new Insets(1, 0, 5, 0), 0, 0));
    add(mainPanel,
        new GridBagConstraints(0, 3, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
    // fromLabel = new JLabel("Convert from:");
    // add(fromLabel, new FlowLayout(FlowLayout.LEFT));

    // fromFahrenheit = new JRadioButton("Fahrenheit", true);
    // fromCelsius = new JRadioButton("Celsius");
    // fromKelvin = new JRadioButton("Kelvin");

    // // add in group
    // fromOptions = new ButtonGroup();
    // fromOptions.add(fromFahrenheit);
    // fromOptions.add(fromCelsius);
    // fromOptions.add(fromKelvin);

    // fromPanel = new JPanel(new GridLayout(1, fromOptions.getButtonCount()));
    // fromPanel.add(fromFahrenheit);
    // fromPanel.add(fromCelsius);
    // fromPanel.add(fromKelvin);
    // add(fromPanel);

    // toLabel = new JLabel("Convert to:");
    // add(toLabel, new FlowLayout(FlowLayout.LEFT));

    // toFahrenheit = new JRadioButton("Fahrenheit");
    // toCelsius = new JRadioButton("Celsius", true);
    // toKelvin = new JRadioButton("Kelvin");

    // // add in group
    // toOptions = new ButtonGroup();
    // toOptions.add(toFahrenheit);
    // toOptions.add(toCelsius);
    // toOptions.add(toKelvin);

    // toPanel = new JPanel(new GridLayout(1, toOptions.getButtonCount()));
    // toPanel.add(toFahrenheit);
    // toPanel.add(toCelsius);
    // toPanel.add(toKelvin);
    // add(toPanel);

    // sourceLabel = new JLabel("Source Temperature:");
    // add(sourceLabel, new FlowLayout(FlowLayout.LEFT));

    // inputPanel = new JPanel(new BorderLayout());
    // inputField = new JTextField();
    // inputField.addActionListener(listener);
    // convesionButton = new JButton("Convert"); // button with text
    // convesionButton.addActionListener(listener);
    // inputPanel.add(inputField);
    // inputPanel.add(convesionButton, BorderLayout.EAST);
    // add(inputPanel);

    // targetLabel = new JLabel("Target Temperature:");
    // add(targetLabel, new FlowLayout(FlowLayout.LEFT));

    // outputField = new JTextField();
    // outputField.setEditable(false);
    // add(outputField);
  }

  private class MyEventListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
    }
  }
}
