package com.capgemini.testepratico3.executor;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
		features = {"src/main/resources/features/"},
		glue = {"com.capgemini.testepratico3.passos","com.capgemini.testepratico3.suporte"},
		tags = "@global"
		)
public class ExecutarTestesCucumber {

}
