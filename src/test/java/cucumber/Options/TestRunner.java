package cucumber.Options;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("featureFiles/AddProduct.feature")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/jsonReports/cucumber-report.json")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/jsonReports/cucumber-report.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefination")
public class TestRunner {

}
