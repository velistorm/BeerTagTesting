package samples;
import base.BaseTestSetup;
import Utils.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static Utils.JSONRequests.postABeerBody;
import static io.restassured.RestAssured.baseURI;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.*;

public class BeerTests extends BaseTestSetup {
    @Test
    public void getAllPostsTest() {
        baseURI = constructBaseUri(Endpoints.getBeerPostsEndpoint());
        printURI("Base URI: ", baseURI);

        Response response = sendRequest("GET", baseURI);
        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");

        response.then().assertThat()
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].style", notNullValue())
                .body("[0].abv", notNullValue());
    }
    @Test
    public void getPostByIDTest() {
        String endpoint = constructBaseUri(Endpoints.getBeerPostsWithIdEndpoint("1"));
        printURI("Base URI: ", endpoint);

        Response response = sendRequest("GET", endpoint);
        printResponse("Response: ", response.asString());

        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("style", notNullValue())
                .body("abv", notNullValue());
    }
    @Test
    public void postAPostTest() {
        baseURI = constructBaseUri(Endpoints.getBeerPostsEndpoint());
        printURI("Base URI: ", baseURI);

        Response response = sendRequest("POST", baseURI, postABeerBody(6));
        printResponse("Response: ", response.asString());

        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("style", notNullValue())
                .body("abv", notNullValue());
    }
    @Test
    public void deleteAPostTest() {
        baseURI = constructBaseUri(Endpoints.getBeerPostsEndpoint());
        printURI("Base URI: ", baseURI);

        Response response = sendRequest("GET", baseURI);
        int lastId = getLastIdFromResponse(response);
        printResponse("The last ID to be deleted: ", String.valueOf(lastId));
        String deleteURI = constructBaseUri(Endpoints.getBeerPostsWithIdEndpoint(String.valueOf(lastId)));
        Response deleteResponse = sendRequest("DELETE", deleteURI);
        Response updatedResponse = sendRequest("GET", baseURI);
        int newLastId = getLastIdFromResponse(updatedResponse);
        printResponse("The new last ID is: ", String.valueOf(newLastId));

        assertEquals(updatedResponse.getStatusCode(), SC_OK, "Deletion failed.");
        assertFalse(isIdPresentInResponse(updatedResponse, lastId));
    }
    @Test
    public void updateAPostTest() {
        baseURI = constructBaseUri(Endpoints.getBeerPostsEndpoint());
        printURI("Base URI: ", baseURI);

        Response response = sendRequest("GET", baseURI);
        int lastId = getLastIdFromResponse(response);
        printResponse("The last ID to be updated: ", String.valueOf(lastId));
        String putURI = constructBaseUri(Endpoints.getBeerPostsWithIdEndpoint(String.valueOf(lastId)));
        Response putResponse = sendRequest("PUT", putURI, postABeerBody(6));
        printResponse("Updated Response: ", putResponse.getBody().asString());

        assertEquals(putResponse.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
        response.then().assertThat()
                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("style", notNullValue())
                .body("abv", notNullValue());
    }
}

