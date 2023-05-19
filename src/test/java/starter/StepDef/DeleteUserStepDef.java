package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // DELETE UNSUCESSFULLY
    @Given("Delete user with exceed id {word}")
    public void deleteUserWithExceedId(String id) {
        reqresAPI.deleteUserWithExceedId(id);
    }
}
