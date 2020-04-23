package Base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestBase {

  protected static WebDriver testDriver;

  protected PomBase pomBase;
protected BaseDB dbBase;
  @BeforeSuite(description = "Starting driver")
  public void setUp(){
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    testDriver = new ChromeDriver();
    testDriver.manage().window().maximize();
    testDriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
    testDriver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    pomBase = new PomBase(testDriver);
  }

  @Parameters({"URL","username","password"})
  @BeforeSuite(dependsOnMethods = "setUp", description = "Loading URL and Logging in")
  public void openURLAndLogin(String URL, String username, String password){
    pomBase.openURL(URL);
    pomBase.login(username, password);
    Assert.assertEquals(pomBase.getTitle(), "My account - My Store");

  }

  @AfterSuite(description = "Closing web browser")
  public void close(){
    pomBase.logoutUser();
    pomBase.closeDriver();
  }
}
