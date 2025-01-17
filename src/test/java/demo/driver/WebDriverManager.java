package demo.driver;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class WebDriverManager {

  private static WebDriver driver;

  public static void openBrowser() {
    WebDriverCapabilities webDriverCapabilities = new WebDriverCapabilities();
    WebDriverFactory webDriverFactory = new WebDriverFactory(webDriverCapabilities);
    driver = webDriverFactory.createDriver();
    driver.manage().window().maximize();
  }

  public static void closeBrowser() {
    driver.quit();
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
