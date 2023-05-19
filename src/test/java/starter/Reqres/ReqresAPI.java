package starter.Reqres;

import io.cucumber.java.th.แต่;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USERS = Constants.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USERS = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USERS = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_SINGLE_USERS = Constants.BASE_URL + "/api/users/{id}";
    public static String POST_REGISTER_USERS = Constants.BASE_URL + "/api/register";
    public static String POST_LOGIN_USERS = Constants.BASE_URL + "/api/login/";


    @Step("Get list users with valid parameter page")
    public void getListUsersValidParamPage(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUsers(File json) {
        SerenityRest.given().
                contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put data user")
    public void putUpdateUsers(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUsers(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }


    // TUGAS
    @Step("Get single users not found")
    public void getSingleUsersNotFound(int id) {
        SerenityRest.given()
                .pathParam("id", id);

    }

    @Step("Get single users")
    public void getSingleUsers(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post Register Successfull")
    public void postRegisterSuccessfully(File json) {
        SerenityRest.given().
                contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Register Unsuccessfull")
    public void postRegisterUnsuccessfully(File json) {
        SerenityRest.given().
                contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login User Successfully")
    public void postLoginUserSuccessfully(File json) {
        SerenityRest.given().
                contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login User Unsuccessfully")
    public void postLoginUserUnsuccessfully(File json) {
        SerenityRest.given().
                contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update User Unsuccessfully")
    public void putUpdateUsersUnsuccessfully(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user with invalid id")
    public void deleteUserWithInvalidId(String id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }
}
