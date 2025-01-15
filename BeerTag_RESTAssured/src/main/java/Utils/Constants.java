package Utils;

public class Constants {
    public static final String BASE_URL = "http://localhost:8081";
    private static String username = "todor";
    private static String pass = "pass1";

    public static String getAuth(){
        return username + " " + pass;
    }

}
