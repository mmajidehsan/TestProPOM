package DataBase;

import java.sql.*;

public class DataBaseSample {
  Connection connection;
  Statement statement;

  String SQLServerURL = "jdbc:sqlserver://Server;databaseName=;user=;password=";

  String MySQLURL = "jdbc:mysql://hostname/ databaseName";

  String OracleURL = "jdbc:oracle:thin:@hostname:port Number:databaseName";

  public void check() throws Exception{

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    /*Class.forName("com.mysql.jdbc.Driver");
    Class.forName("oracle.jdbc.driver.OracleDriver");*/



    connection = DriverManager.getConnection(SQLServerURL);

    statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

    ResultSet resultSet = statement.executeQuery("select id,name,salary,age,address from table1 where name='mukarran' and city='lhr'");


    while(resultSet.next()){

      String name = resultSet.getString("name");
      String id = resultSet.getString("id");

      resultSet.updateString("FirstName", "MME");
      resultSet.updateInt("phone", 1231546);
    }
    resultSet.beforeFirst();

    resultSet.close();
    statement.close();
    connection.close();
  }
}
