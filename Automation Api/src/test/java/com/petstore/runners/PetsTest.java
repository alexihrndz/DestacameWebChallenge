package com.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/petstore.feature",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    glue = "com.petstore.stepdefinitions",
    plugin = "rerun:target/rerun.txt")
public class PetsTest {}
