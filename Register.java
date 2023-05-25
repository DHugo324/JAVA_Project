package loginSystem;

import java.sql.*;
import java.lang.Class;

public class Register implements IPaddress {

  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private PreparedStatement pStatement = null;
  private String dropdbSQL = "DROP TABLE User ";
  private String name;
  private String passwd;

  // 建構子，初始化要註冊的資料，並與資料庫取得連線
  public Register(String name, String passwd) {
    this.name = name;
    this.passwd = passwd;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(
          "jdbc:mysql://" + ip + "/" + dbName + "?useUnicode=true&characterEncoding=Big5",
          sqldbaccount, sqldbpass);
    } catch (ClassNotFoundException e) {
      System.out.println(e);
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public int insertTable() {
    int confirm = selectTable();// 先去資料表查使用者名稱有無重複
    int flag = 0;
    String insertdbSQL = "insert into User(id,name,nickName, passwd) " +
        "select ifNULL(max(id),0)+1,?,?,? FROM User";
    try {
      if (confirm == 0) {// 沒有重複使用者
        pStatement = connection.prepareStatement(insertdbSQL);
        pStatement.setString(1, name);
        pStatement.setString(2, passwd);
        pStatement.executeUpdate();
        creatTable_friend();
        // creatTable_chat();
        flag = 1;
      } else
        System.out.println("重複");
    } catch (SQLException e) {
      System.out.println(e);
    } finally {
      closedb();
    }
    return flag;// 成功註冊回傳1
  }

  public int selectTable() {
    String selectSQL = "select * from User ";
    int flag = 0;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectSQL);
      while (resultSet.next()) {
        if (resultSet.getString("name").equals(name))
          flag = 1;
      }
    } catch (SQLException e) {
      System.out.println("selectTable:" + e);
    } finally {
      closedb();
    }
    return flag;// 有重複使用者回傳1
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

  public void creatTable_friend() {// 創建資料表
    String createdbSQL_friend = "CREATE TABLE " + name + "_friend (" +
        "    id     INTEGER " +
        "  , name    VARCHAR(20)" +
        "  , state VARCHAR(8))";
    try {
      statement = connection.createStatement();
      statement.executeUpdate(createdbSQL_friend);
    } catch (SQLException e) {
      // System.out.println(e);
    } finally {
      closedb();// 最後一定要關閉
    }
  }
}
