package POM.Home;

import Base.PomBase;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@Slf4j
public class HomePOM extends PomBase {

  HomeLocator locator;

  public HomePOM(WebDriver externalDriver) {
    super(externalDriver);
    locator = new HomeLocator(externalDriver);
  }

  @Step("Searching product")
  public void searchProduct(String product){
    locator.getSearchBar().sendKeys(product);
    locator.getSearchButton().click();
  }

  @Step("Fetching product count")
  public String getSearchCount(){
    return locator.getProductCount().getText().trim();
  }















  @Step("Adding to cart {0}")
  public void addToCart(String productName){
    List<WebElement> products = locator.getAllFeaturedProducts();
    for(WebElement prouct:products){
      String fetchedProductName = locator.getProductName(prouct).getText();
      if(fetchedProductName.equalsIgnoreCase(productName)){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator.getProductName(prouct)).perform();
        locator.getAddToCart(prouct).click();
      }
      while(locator.getProductQuantity().getText().equalsIgnoreCase("")){

      }
      String quantity = locator.getProductQuantity().getText();
      log.info("Quantity: " + quantity);
      String totalPrice = locator.getCartPrice().getText();
      log.info("Price: " + totalPrice);
      locator.getCloseCartPopUp().click();
    }
  }


}
