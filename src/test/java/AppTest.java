import java.util.ArrayList;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer");
  }

  @Test
  public void compactDiskIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add New CD"));
    fill("#title").with("Summer rose");
    submit(".btn");
    assertThat(pageSource()).contains("Your CD has been saved.");
  }

  @Test
  public void compactDiskProperStorage(){
    goTo("http://localhost:4567/");
    click("a", withText("Add New CD"));
    fill("#title").with("Summer rose");
    submit(".btn");
    click("a", withText("View CDs"));
    assertThat(pageSource()).contains("Summer rose");

  }

  @Test
  public void compactDiskShowsIndiviualCD(){
    goTo("http://localhost:4567/compactdisks/new");
    fill("#title").with("Summer Rose");
    submit(".btn");
    click("a", withText("View CDs"));
    click("a", withText("Summer Rose"));//Does not work if Rose is lowercase
    assertThat(pageSource()).contains("Summer Rose");
  }

  @Test
  public void cdNotFound() {
    goTo("http://localhost:4567/compactdisks/999");
    assertThat(pageSource()).contains("No CDs entered here at the moment");
  }
}
