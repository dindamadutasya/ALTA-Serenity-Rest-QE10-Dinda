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

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // POST REGISTER SUCCESSFULLY
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterReqBody.json");
        reqresAPI.postRegisterSuccessfully(json);
    }

    @When("Send post register user")
    public void sendPostRegisterUser() {

        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USERS);
    }

    @And("Response body token should be {string} and id {int}")
    public void responseBodyTokenShouldBeAndId(String token, int id) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token))
                          .body(ReqresResponses.ID, equalTo(id));


    }
    @And("Validate register user JSON Schema")
    public void validateRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "ValidRegisterJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // POST REGISTER UNSUCCESSFULLY
    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"InvalidRegisterReqBody.json");
        reqresAPI.postRegisterUnsuccessfully(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }


    @And("Validate invalid register user JSON Schema")
    public void validateInvalidRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "InvalidRegisterUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
