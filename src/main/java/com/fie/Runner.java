package com.fie;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features\\soucedemotest",
        glue = "com.fie.stepdef", tags = "@only", plugin = {"html: build/cucumber/cucumber-pretty.html", "pretty"})
public class Runner {
}
