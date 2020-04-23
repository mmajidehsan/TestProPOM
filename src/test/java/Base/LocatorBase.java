package Base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorBase {
  protected WebDriver driver;

  public LocatorBase(WebDriver testDriver){
    driver = testDriver;
  }

  @Step("In LocatorBase getLoginLink")
  WebElement getLoginLink(){
    return driver.findElement(By.className("login"));
  }

  @Step("In LocatorBase getEmail")
  WebElement getEmail(){
    return driver.findElement(By.id("email"));
  }

  @Step("In LocatorBase getPassword")
  WebElement getPassword(){
    return driver.findElement(By.id("passwd"));
  }

  @Step("In LocatorBase getLoginButton")
  WebElement getLoginButton(){
    return driver.findElement(By.id("SubmitLogin"));
  }

  @Step("In LocatorBase getLogout")
  WebElement getLogout(){
    return driver.findElement(By.className("logout"));
  }

  @Step("In LocatorBase getHomePageLogo")
  WebElement getHomePageLogo(){
    return driver.findElement(By.id("header_logo"));
  }
}
