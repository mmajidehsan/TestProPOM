package Base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PomBase {
  protected WebDriver driver;

  LocatorBase locatorBase;


  public PomBase(WebDriver externalDriver){
    driver = externalDriver;
    locatorBase = new LocatorBase(externalDriver);
  }
@Step("In POMBase Open URL")
  public void openURL(String URL){
    driver.get(URL);
  }

  @Step("IN POMBase login")
  public void login(String username, String password){
    locatorBase.getLoginLink().click();
    locatorBase.getEmail().sendKeys(username);
    locatorBase.getPassword().sendKeys(password);;
    locatorBase.getLoginButton().click();
  }

  @Step("POMBase gotoHome")
  public void goToHome(){
    locatorBase.getHomePageLogo().click();
  }

  @Step("POMBase getTitle")
  public String getTitle(){
    return driver.getTitle();
  }

  @Step("In POMBase Closing driver")
  public void closeDriver(){
    driver.quit();
  }

  @Step("In POMBase logout")
  public void logoutUser(){
    locatorBase.getLogout().click();
  }
}
