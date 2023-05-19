package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // PUT UPDATE UNSUCESSFULLY
    @Given("Put Update User with Invalid json and valid id {int}")
    public void putUpdateUserWithInvalidJSON(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"InvalidUserReqBody.json");
        reqresAPI.putUpdateUsers(id, json);
    }

}
