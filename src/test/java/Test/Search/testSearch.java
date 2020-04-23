package Test.Search;

import Base.TestBase;
import DataBase.SearchProduct;
import POM.Home.HomePOM;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class testSearch extends TestBase {
  HomePOM homePo;

  @BeforeTest
  public void setupTest(){
    homePo = new HomePOM(testDriver);
    homePo.goToHome();
  }

  @Parameters({"server","database","user","DBpassword"})
  @Test(description = "Testing search feature")
  public void searchTest() throws Exception{
    homePo.searchProduct("dress");
    String result = homePo.getSearchCount();
    /*SearchProduct searchProduct = new SearchProduct(server, database, user, DBpassword);
    searchProduct.connectDB();
    searchProduct.createStatement();
    searchProduct.createProductQuery("dress");
    ResultSet productResultSet = searchProduct.executeQuery();*/


//    searchProduct.closeConnection();
    Assert.assertEquals(result, "Showing 1 - 7 of 7 items");
  }
}
