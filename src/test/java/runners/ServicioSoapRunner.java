package runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src\\test\\resources\\features\\ServicioSoap.feature" }, glue = {
		"steps" }, snippets = CAMELCASE)
public class ServicioSoapRunner {
}
