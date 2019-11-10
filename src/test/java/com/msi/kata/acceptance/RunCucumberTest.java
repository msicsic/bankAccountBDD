package com.msi.kata.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.msi.kata.acceptance"},
        plugin = {"pretty"})
public class RunCucumberTest {

}
