package loginSystem;

import java.sql.*;

public class Login implements IPaddress {
  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private PreparedStatement pStatement = null;
  private String name;
  private String passwd;

  public Login(String name, String passwd) {
    this.name = name;
    this.passwd = passwd;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
          "jdbc:mysql://" + ip + "/" + dbName + "?useUnicode=true&characterEncoding=Big5",
          sqldbaccount, sqldbpass);
    } catch (ClassNotFoundException e) {
      // System.out.println(e);
    } catch (SQLException e) {
      // System.out.println(e);
    }
  }

  public int selectTable() {
    String selectSQL = "select * from User ";
    int flag = 0;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectSQL);
      while (resultSet.next()) {// 如果使用者名稱和密碼都正確
        if (resultSet.getString("name").equals(name) && resultSet.getString("passwd").equals(passwd)) {
          flag = 1;
        }
      }
    } catch (SQLException e) {
      // System.out.println("selectTable:"+e);
    } finally {
      closedb();
    }
    return flag;
  }

  public void closedb() {
    try {
      if (resultSet != null) {
        resultSet.close();
        resultSet = null;
      }
      if (statement != null) {
        statement.close();
        statement = null;
      }
      if (pStatement != null) {
        pStatement.close();
        pStatement = null;
      }
    } catch (SQLException e) {
      // System.out.println(e);
    }
  }

}