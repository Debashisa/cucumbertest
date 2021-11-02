package com.example.integration.cucumbertest.stepsdef;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
public class TestStepsDefinition {

    private static final Logger log=LoggerFactory.getLogger(TestStepsDefinition.class);

    @Autowired
    private MockMvc mockMvc;

    private ResultActions mockResultActions;

    @Before
    public void setUp(){
        log.info("Running the step !");
    }

    @When("Call Rest API")
    public void whenCallAPI() throws Exception {

        mockResultActions = mockMvc.perform(MockMvcRequestBuilders.
                        get("/test")
                        .contentType(MediaType.APPLICATION_JSON)
        );
    }

    @Then("Receive a Return")
    public void thenShouldReturnString() throws Exception {

       mockResultActions.andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string("returning"));                
    }
    
}
