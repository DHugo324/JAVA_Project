package java2023.project;

import java.io.*;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class BoardReader implements Board {
  private final String[] fileNames = { "useLib\\classMessages.txt", "useLib\\others.txt", "useLib\\messageBoard.txt" };
  private Scanner input;
  private String fileName = "useLib\\classMessages.txt"; // target file name
  private ArrayList<msg> messages = new ArrayList<msg>();

  public BoardReader(int kind) {
    this.fileName = fileNames[kind];
  }

  public ArrayList<msg> getMessages() {
    openFile();
    readRecords();
    closeFile();
    return messages;
  }

  @Override
  public void openFile() {
    try {
      input = new Scanner(Paths.get(fileName));
    } catch (IOException ioException) {
      System.err.println("Error opening file. Terminating.");
      System.exit(1);
    }
  }

  public void readRecords() {

    try {
      while (input.hasNext()) // while there is more to read
      {
        String user = input.nextLine();
        String date = input.nextLine();
        String message = input.nextLine();
        messages.add(new msg(user, date, message));
      }
    } catch (NoSuchElementException elementException) {
      System.err.println("File improperly formed. Terminating.");
    } catch (IllegalStateException stateException) {
      System.err.println("Error reading from file. Terminating.");
    }

  } // end method readRecords

  // close file and terminate application
  @Override
  public void closeFile() {
    if (input != null)
      input.close();
  }
}
