package demo.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebDriverConfigProperties {

  private String url;
  private String seleniumHubUrl;
  private String browser;
  private Boolean remote;
  private Boolean headless;
  private int waitTime;
}
