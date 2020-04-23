package Base;

import java.sql.*;

public class BaseDB {
  Connection connection;
  Statement statement;
  String connectionURL;
  protected String SQL;
  public BaseDB(String server, String database, String user, String password){
    connectionURL = "jdbc:sqlserver://" + server +
            ";databaseName=" + database +
            ";user=;password=";

  }

  public void connectDB() throws Exception{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    connection = DriverManager.getConnection(connectionURL);
  }

  public void createStatement() throws SQLException{
    statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
  }

  public ResultSet executeQuery() throws SQLException{
    return statement.executeQuery(SQL);
  }

  public void closeConnection() throws SQLException{
    connection.close();
  }
}
