package java2023.project;

import java.io.IOException;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.util.*;

public class messageBoard {
  private Scanner input;
  private final String fileName = "messageBoard.txt"; // target file name
  private ArrayList<msg> messages = new ArrayList<msg>();

  public messageBoard() {
    openFile();
    readRecords();
    closeFile();
  }

  public ArrayList<msg> getMessages() {
    return messages;
  }

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
  public void closeFile() {
    if (input != null)
      input.close();
  }
}
