package Utils;

public class Endpoints {
    //Beers
    private static final String BEER_POSTS_ENDPOINT = "/api/beers";

    public static String getBeerPostsEndpoint(){
        return BEER_POSTS_ENDPOINT;
    }
    public static String getBeerPostsWithIdEndpoint(String id){
        return BEER_POSTS_ENDPOINT + "/" + id;
    }
    //Users
    private static final String USERS_ENDPOINT = "/api/users";
    public static String getUsersEndpoint(){
        return USERS_ENDPOINT;
    }
    public static String getUserEndpointByID(String id){
        return USERS_ENDPOINT + "/" + id;
    }
    public static String getUserEndpointByIDWishlist(String id){
        return USERS_ENDPOINT + "/" + id + "/wish-list";
    }
    public static String getUserPostByID(String userId, String postId){
        return USERS_ENDPOINT + "/" + userId + "/wish-list/" + postId;
    }
}
