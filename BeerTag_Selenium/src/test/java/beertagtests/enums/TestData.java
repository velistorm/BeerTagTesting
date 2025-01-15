package beertagtests.enums;

import static beertagtests.core.RandomDataGenerator.*;

public enum TestData {
    USER_PASSWORD("1234"),
    USERNAME("test123"),
    //ADMIN_USERNAME(getRandomString(4)+"admin"),
    ADMIN_USERNAME("velistorm"),
    ADMIN_PASSWORD("1234"),
    REGISTER_USERNAME(getRandomString(8)),
    REGISTER_PASSWORD("passwordtest"),
    EMAIL(generateEmail()),
    FIRST_NAME(getRandomString(5)),
    LAST_NAME(getRandomString(5)),
    STD_BEER_NAME("Standard " + getRandomString(4)),
    ADMIN_BEER_NAME("Admin " + getRandomString(4));
    //UPDATE_EMAIL(generateEmail()),
    //UPDATE_BIRTHDAY("11111990"),
    //UPDATE_FIRSTNAME(getRandomString(8)),
    //UPDATE_LASTNAME(getRandomString(6)),
    //UPDATE_ABOUT_ME(String.format("Hello, my name is %s and I updated my info.", UPDATE_FIRSTNAME));

    private final String value;
    
    TestData(String propName) {
        value = propName;
    }

    public String getValue() {
        return value;
    }
}
