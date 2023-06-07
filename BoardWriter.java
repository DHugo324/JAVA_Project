package java2023.project;

import java.io.*;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class BoardWriter implements Board {
  private final String[] fileNames = { "useLib\\classMessages.txt", "useLib\\others.txt", "useLib\\messageBoard.txt" };
  private static Formatter output; // outputs text to a file
  private String fileName; // target file name

  public BoardWriter(int kind) {
    this.fileName = fileNames[kind];
  }

  public void addMessage(String user, String date, String context) {
    openFile();
    addRecord(user, date, context);
    closeFile();
  }

  @Override
  public void openFile() {
    try {
      FileWriter fw = new FileWriter(fileName, true);
      output = new Formatter(fw);
    } catch (SecurityException securityException) {
      System.err.println("Write permission denied. Terminating.");
      System.exit(1); // terminate the program
    } catch (FileNotFoundException fileNotFoundException) {
      System.err.println("Error opening file. Terminating.");
      System.exit(1); // terminate the program
    } catch (IOException e) {
      System.err.println("I/O error. Terminating.");
      System.exit(1); // terminate the program
    }
  }

  // add records to file
  public void addRecord(String user, String date, String context) {
    try {
      // output new record to file; assumes valid input
      output.format("%s%n%s%n", user, date);
      output.format("%s%n", context);
    } catch (FormatterClosedException formatterClosedException) {
      System.err.println("Error writing to file. Terminating.");
    }
  }

  // close file
  @Override
  public void closeFile() {
    if (output != null)
      output.close();
  }
}