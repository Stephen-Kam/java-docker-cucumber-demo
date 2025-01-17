package demo.stepdefs;

import demo.driver.WebDriverConfig;
import demo.driver.WebDriverConfigProperties;
import demo.driver.WebDriverManager;
import io.cucumber.java.AfterAll;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.BeforeAll;
import lombok.RequiredArgsConstructor;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

@RequiredArgsConstructor
public class Hooks {

  private static final WebDriverConfigProperties webDriverProps =
      ConfigLoader.loadYmlConfigFromResource(
          "config/webdriver.yml", WebDriverConfigProperties.class);

  @BeforeAll
  public static void beforeAll() {
    WebDriverConfig.setTargetUrl(webDriverProps.getUrl());
    WebDriverConfig.setSeleniumHubUrl(webDriverProps.getSeleniumHubUrl());
    WebDriverConfig.setBrowser(webDriverProps.getBrowser());
    WebDriverConfig.setRemote(webDriverProps.getRemote());
    WebDriverConfig.setHeadless(webDriverProps.getHeadless());
    WebDriverConfig.setWaitTime(webDriverProps.getWaitTime());

    if (WebDriverManager.getDriver() == null) {
      WebDriverManager.openBrowser();
    }

    WebDriverManager.getDriver()
        .manage()
        .timeouts()
        .implicitlyWait(webDriverProps.getWaitTime(), TimeUnit.SECONDS);
    WebDriverManager.getDriver()
        .manage()
        .timeouts()
        .pageLoadTimeout(webDriverProps.getWaitTime(), TimeUnit.SECONDS);
  }

  @AfterAll
  public static void afterAll() {
    WebDriverManager.closeBrowser();
  }
}
