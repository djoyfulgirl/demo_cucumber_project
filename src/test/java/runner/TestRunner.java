package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", 
glue="TestCaseExecution",
plugin = {"pretty","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtendedReport.html","junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-html-reports","json:target/cucumber-reports/cucumber.json","html:target/Cucumber-JVM-report"},
monochrome =true 
,strict=true 
,dryRun = false

//,tags = {"@loginpage"}
)
        


public class TestRunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void writeExtentReport() {
    	String reportConfigPath = System.getProperty("user.dir")+"\\config\\extent-config.xml";
        Reporter.loadXMLConfig(new File(reportConfigPath));
        Reporter.setSystemInfo("User Name", "Tawa");
        Reporter.setSystemInfo("Machine", "Windows 10 " + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}


