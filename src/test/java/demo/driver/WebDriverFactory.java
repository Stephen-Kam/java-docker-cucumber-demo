package demo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {

  private static final Logger log = LoggerFactory.getLogger(WebDriverFactory.class);

  private final WebDriverCapabilities webDriverCapabilities;

  public WebDriverFactory(WebDriverCapabilities webDriverCapabilities) {
    this.webDriverCapabilities = webDriverCapabilities;
  }

  public WebDriver createDriver() {
    WebDriver driver;
    if (WebDriverConfig.isRemote()) {
      driver = this.createRemoteDriver();
    } else {
      driver = this.createLocalDriver();
    }

    return driver;
  }

  private RemoteWebDriver createRemoteDriver() {
    URL hubUrl = null;

    try {
      hubUrl = new URL(WebDriverConfig.getSeleniumHubUrl() + "/wd/hub");
    } catch (MalformedURLException ex) {
      log.error(ex.getClass().getName(), ex);
    }

    return this.createRemoteDriver(hubUrl);
  }

  private WebDriver createLocalDriver() {
    WebDriver driver = null;
    WebDriverManager.chromedriver().clearDriverCache().setup();
    driver = new ChromeDriver(this.webDriverCapabilities.getChromeOptions());
    return driver;
  }

  private RemoteWebDriver createRemoteDriver(URL hubUrl) {
    RemoteWebDriver driver = null;
    switch (WebDriverConfig.getBrowser().toLowerCase()) {
      case "chrome" ->
          driver = new RemoteWebDriver(hubUrl, this.webDriverCapabilities.getChromeOptions());
      default -> throw new IllegalArgumentException();
    }

    return driver;
  }
}

