package DataBase;

import Base.BaseDB;

public class SearchProduct extends BaseDB {

  public SearchProduct(String server, String database, String user, String password){
    super(server, database, user, password);
  }

  public void createProductQuery(String product){
    SQL = "Select * from products where pro_name = '" + product +"'";
  }

  public void createProductQuery(String product, String brand){
    SQL = "Select * from products where pro_name = '" + product +"' and brand = '" +
    brand + "'";
  }
}
