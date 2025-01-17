package demo.stepdefs;

import demo.pages.GovUkPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExampleSteps {

  GovUkPage govUkPage = new GovUkPage();

  @When("A user navigates to the GOV UK website")
  public void userNavigatesToWebsite() {
    govUkPage.navigateTo("https://www.gov.uk");
  }

  @Then("the correct heading is visible")
  public void correctHeadingIsVisible() throws InterruptedException {
    Thread.sleep(10000);
    Assert.assertTrue(govUkPage.findByCss("h1").getText().contains("GOV.UK"));
  }
}
