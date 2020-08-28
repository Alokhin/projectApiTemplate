package apiEngine.model.project.endPoints;

public class Rout {

    public static String path = "/";

    public static String USERS = "/xxxxx";
    public static String API = "/api";
    public static String USER = "/xxxxx";
    public static String DELETE = "/xxxx";


    public static String users() {
        return USERS + API + "/xxxxxxx/";
    }

    public static String usersId(int id) {
        return USERS + API + USER + "/" + id;
    }

    public static String userId(int customerIds) {
        return USERS + API + USER + "/" + customerIds + "/customers";
    }

    public static String deleteUserId(int customerIds) {
        return USERS + API + USER + "/" + customerIds + DELETE + "/customers";
    }
}
