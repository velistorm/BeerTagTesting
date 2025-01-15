package Utils;
import org.apache.commons.lang3.RandomStringUtils;

public class JSONRequests {
    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }
    public static String postABeerBody(Integer nameLength) {
        String randomBeerName = getRandomString(nameLength); // Generate a random name of 10 characters
        return String.format("{\n" +
                "  \"name\": \"%s\",\n" +
                "  \"abv\": 7,\n" +
                "  \"styleId\": 2\n" +
                "}", randomBeerName);
    }
}
