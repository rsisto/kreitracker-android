package kreitech.io.kreitrackerandroid;

import java.io.IOException;

import kreitech.io.kreitrackerandroid.models.User;
import kreitech.io.services.ApiService;
import kreitech.io.services.KRestClient;

/**
 * Created by sebastian on 25/03/16.
 */
public class Facade {

    private static Facade instance = null;
    private KRestClient client;
    private ApiService api;

    private Facade() {
        this.client = new KRestClient();
        this.api = client.getApiService();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public User getUser(String id) {
        User user = null;
        try {
            user = api.getUser(id).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public User registerUser(String username, String name, String email, String password) {
        User user = new User();
        try {
            user.setUserName(username);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user = api.registerUser(user).execute().body();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User login(String username, String password) {
        User user = new User();
        try {
            user.setUserName(username);
            user.setPassword(password);
            user = api.login(user).execute().body();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
