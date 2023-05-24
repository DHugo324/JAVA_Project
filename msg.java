package java2023.project;

public class msg {
  private String user;
  private String date;
  private String message;

  public msg(String user, String date, String message) {
    this.user = user;
    this.date = date;
    this.message = message;
  }

  public String getUser() {
    return user;
  }

  public String getDate() {
    return date;
  }

  public String getMessage() {
    return message;
  }
}
