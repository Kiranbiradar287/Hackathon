package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/hackthon.feature"},
		glue="stepdefinition",
		plugin= {"pretty","html:.//cucumberReport1/reports1.html"})
public class Run {
}
