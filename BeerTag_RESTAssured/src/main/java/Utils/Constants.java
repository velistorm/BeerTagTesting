package Utils;

import io.restassured.response.Response;

public class Constants {

    //private static Response response;
    /*Samples tests constants*/
    public static final String BASE_URL = "http://localhost:8081";
    public static final String EMAIL_SAMPLES = "michael.lawson@reqres.in";
    public static final String PASSWORD_SAMPLES = "12345678DG";
    public static Integer USER_ID = null;

    private static String username = "todor";
    private static String pass = "pass1";

    public static String getAuth(){
        return username + " " + pass;
    }

}
