package com.example.integration.cucumbertest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
@RunWith(Cucumber.class)
@AutoConfigureMockMvc
@CucumberOptions(
        plugin = {"pretty", "junit:build/report-results/cucumber.xml"},
        features = "src/test/resources"
)
class RestApiTest {


}
