package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/FeatureFile"
,glue="stepDefination",
monochrome=true,
publish=true
,plugin= {"pretty","json:target/JsonReports/cucumberjsosnreport.json"
		,"html:target/HtmlReports/cucumberhtmlreport.html"})



public class RunnerTest {

}
