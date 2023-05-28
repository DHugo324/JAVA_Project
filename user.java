package java2023.project;

public class user {
  private String major;
  private String id;
  private int access;

  public user(String major, String id, int access) {
    this.major = major;
    this.id = id;
    this.access = access;
  }

  public String getMajor() {
    return major;
  }

  public String getID() {
    return id;
  }

  public int getAccess() {
    return access;
  }
}
