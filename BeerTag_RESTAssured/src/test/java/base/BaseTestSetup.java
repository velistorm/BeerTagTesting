package base;

import Utils.Constants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static Utils.Constants.BASE_URL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class BaseTestSetup {
    public String constructBaseUri(String endpoint) {
        return String.format("%s%s", BASE_URL, endpoint);
    }
    public int getLastIdFromResponse(Response response) {
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("id");
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("Response does not contain any IDs.");
        }
        return ids.get(ids.size() - 1);
    }
    protected static void printResponse(String label, String response) {
        System.out.println(label + response);
    }

    protected static void printURI(String label, String uri) {
        System.out.println(label + uri);
    }
    protected void sendAndValidateRequestForUserTest(String method, String endpoint) {
        baseURI = format("%s%s", BASE_URL, endpoint);
        printURI("Base URI: ", baseURI);

        Response response = given()
                .header("Authorization", Constants.getAuth())
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .when()
                .request(method);

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
    }
    protected void sendAndValidateRequestForBeerTest(String method, String endpoint, String body, Response response) {
        baseURI = constructBaseUri(endpoint);
        printURI("Base URI: ", baseURI);

        response = given()
                .header("Authorization", Constants.getAuth())
                .header("Accept", "*/*")
                .contentType("application/json")
                .body(body != null ? body : "")
                .when()
                .request(method);

        printResponse("Response: ", response.asString());
        assertEquals(response.getStatusCode(), SC_OK, "Incorrect status code. Expected 200.");
    }
    protected boolean isIdPresentInResponse(Response response, int id) {
        List<Integer> ids = response.jsonPath().getList("id", Integer.class);
        return ids.contains(id);
    }

    protected Response sendRequest(String method, String endpoint, Object body) {
        return given()
                .header("Authorization", Constants.getAuth())
                .header("Accept", "*/*")
                .contentType("application/json")
                .body(body)
                .when()
                .request(method, endpoint);
    }

    protected Response sendRequest(String method, String endpoint) {
        return given()
                .header("Authorization", Constants.getAuth())
                .header("Accept", "*/*")
                .when()
                .request(method, endpoint);
    }
    @BeforeMethod()
    public void setUp() {

    }
}