package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // GET INVALID SINGLE USER
    @Given("Get sigle user with exceed id {int}")
    public void getSigleUserWithExceedId(int id) {

        reqresAPI.getSingleUsers(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {

        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {

        SerenityRest.then().statusCode(notFound);
    }

    // GET VALID SINGLE USER
    @Given("Get sigle user with valid id {int}")
    public void getSigleUserWithValidId(int id) {

        reqresAPI.getSingleUsers(id);
    }

    @And("Validate single user JSON Schema")
    public void validateSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "SingleUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body name was id {int}")
    public void responseBodyNameWasId(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }
}
