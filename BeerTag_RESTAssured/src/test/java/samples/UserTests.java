package samples;

import Utils.Endpoints;
import base.BaseTestSetup;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static Utils.Constants.BASE_URL;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;

public class UserTests extends BaseTestSetup {
    @Test
    public void getAllUsersTest() {
        String endpoint = Endpoints.getUsersEndpoint();
        Response response = sendRequest("GET", format("%s%s", BASE_URL, endpoint));

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("[0].id", notNullValue())
                .body("[0].username", notNullValue())
                .body("[0].firstName", notNullValue())
                .body("[0].lastName", notNullValue());
    }
    @Test
    public void getASingleUserTest() {
        String endpoint = Endpoints.getUserEndpointByID("1");
        Response response = sendRequest("GET", format("%s%s", BASE_URL, endpoint));

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("id", notNullValue())
                .body("username", notNullValue())
                .body("firstName", notNullValue())
                .body("lastName", notNullValue());
    }
    @Test
    public void getAUserWishlist() {
        String endpoint = Endpoints.getUserEndpointByIDWishlist("1");
        Response response = sendRequest("GET", format("%s%s", BASE_URL, endpoint));

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("style", notNullValue())
                .body("abv", notNullValue());
    }
    @Test
    public void userAddsABeerToWishlist() {
        String endpoint = Endpoints.getUserPostByID("1", "1");
        Response response = sendRequest("PUT", format("%s%s", BASE_URL, endpoint));

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
    }
    @Test
    public void userRemovesABeerFromWishlist() {
        String endpoint = Endpoints.getUserPostByID("1", "1");
        Response response = sendRequest("DELETE", format("%s%s", BASE_URL, endpoint));

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
    }
}
