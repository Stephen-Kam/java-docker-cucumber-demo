package demo.driver;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WebDriverConfig {

  private static String targetUrl;
  private static String seleniumHubUrl;
  private static String browser;
  private static Boolean remote;
  private static Boolean headless;
  private static int waitTime;

  public static String getBrowser() {
    if (browser == null) {
      browser = "chrome";
    }

    return browser;
  }

  public static String getTargetUrl() {
    return targetUrl;
  }

  public static String getSeleniumHubUrl() {
    return seleniumHubUrl;
  }

  public static Boolean isRemote() {
    return remote;
  }

  public static Boolean isHeadless() {
    return headless;
  }

  public static int getWaitTime() {
    return waitTime;
  }

  public static void setBrowser(String browser) {
    WebDriverConfig.browser = browser;
  }

  public static void setTargetUrl(String targetUrl) {
    WebDriverConfig.targetUrl = targetUrl;
  }

  public static void setSeleniumHubUrl(String seleniumHubUrl) {
    WebDriverConfig.seleniumHubUrl = seleniumHubUrl;
  }

  public static void setRemote(Boolean remote) {
    WebDriverConfig.remote = remote;
  }

  public static void setHeadless(Boolean headless) {
    WebDriverConfig.headless = headless;
  }

  public static void setWaitTime(int waitTime) {
    WebDriverConfig.waitTime = waitTime;
  }
}
