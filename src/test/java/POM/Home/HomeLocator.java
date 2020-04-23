package POM.Home;

import Base.LocatorBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HomeLocator extends LocatorBase {
  public HomeLocator(WebDriver testDriver) {
    super(testDriver);
  }

  @Step("In HomeLocator getSearchBar")
  WebElement getSearchBar(){
    return driver.findElement(By.id("search_query_top"));
  }

  @Step("In HomeLocator getSearchButton")
  WebElement getSearchButton(){
    return driver.findElement(By.name("submit_search"));
  }

  @Step("In HomeLocator getProductCount")
  WebElement getProductCount(){
    return driver.findElement(By.className("product-count"));
  }

  @Step("In HomeLocator getProductCount")
  WebElement getProductCountWait(){
    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
    WebElement productCount = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-count")));
    return productCount;
  }

  @Step("In HomeLocator getProductCount")
  WebElement getProductCountFluentWait(){
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofSeconds(10))
            .ignoring(NoSuchElementException.class);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-count")));

    WebElement productCount = wait.until(new Function<WebDriver, WebElement>() {
      @Override
      public WebElement apply(WebDriver webDriver) {

        return webDriver.findElement(By.className("product-count"));
      }
    });
    return driver.findElement(By.className("product-count"));
  }





















  @Step("In HomeLocator getAllFeaturedProducts")
  List<WebElement> getAllFeaturedProducts(){
    WebElement productBlock = driver.findElement(By.cssSelector("ul#homefeatured"));
    return productBlock.findElements(By.tagName("li"));
  }
  @Step("In HomeLocator getProductName")
  WebElement getProductName(WebElement productItem){
    return productItem.findElement(By.className("right-block"))
            .findElement(By.className("product-name"));
  }

  WebElement getAddToCart(WebElement productItem){
    return productItem.findElement(By.className("right-block"))
            .findElement(By.partialLinkText("Add"));
  }

  WebElement getProductQuantity(){
    return driver.findElement(By.id(HomeConstant.ProductQuantity));
  }

  WebElement getCartPrice(){
    return driver.findElement(By.id(HomeConstant.ProductPrice));
  }

  WebElement getCloseCartPopUp(){
    return driver.findElement(By.className("cross"));
  }

}
