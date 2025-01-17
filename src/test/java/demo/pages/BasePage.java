package demo.pages;

import demo.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

  public final WebDriver driver;

  public BasePage() {
    driver = WebDriverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  public void navigateTo(String url) {
    driver.navigate().to(url);
  }

  public WebElement findByCss(String css) {
    return driver.findElement(By.cssSelector(css));
  }
}

