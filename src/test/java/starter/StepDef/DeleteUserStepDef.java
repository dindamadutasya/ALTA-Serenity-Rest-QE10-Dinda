package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // DELETE UNSUCESSFULLY
    @Given("Delete user with invalid id {word}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteUserWithInvalidId(id);
    }
}
