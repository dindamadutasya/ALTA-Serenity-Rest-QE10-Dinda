package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jnr.constants.Constant;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    // POST LOGIN SUCCESSFULLY
    @Given("User login with valid json")
    public void userLoginWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"ValidLoginBody.json");
        reqresAPI.postLoginUserSuccessfully(json);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {

        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USERS);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate login user JSON Schema")
    public void validateLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "ValidLoginUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // POST LOGIN UNSUCCESSFULLY
    @Given("User login with invalid json")
    public void userLoginWithInvalidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"InvalidLoginReqBody.json");
        reqresAPI.postLoginUserUnsuccessfully(json);
    }


    @And("Validate unsuccessfully login user JSON Schema")
    public void validateUnsuccessfullyLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "InvalidLoginUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @And("Response body error was {string}")
    public void responseBodyErrorWas(String error) {
        SerenityRest.and().body("error", equalTo(error));
    }
}
