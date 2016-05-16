package kreitech.io.kreitrackerandroid;

import java.io.IOException;

import kreitech.io.kreitrackerandroid.models.User;
import kreitech.io.kreitrackerandroid.responses.LoginResponse;
import kreitech.io.kreitrackerandroid.responses.PhoneImeiRequest;
import kreitech.io.kreitrackerandroid.responses.PhoneImeiResponse;
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

    public LoginResponse login(String username, String password) {
        User user = new User();
        LoginResponse response;
        try {
            user.setUserName(username);
            user.setPassword(password);
            response = api.login(user).execute().body();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PhoneImeiResponse sendPhoneImei(String phone, Integer imei) {
        PhoneImeiRequest request = new PhoneImeiRequest();
        PhoneImeiResponse response;
        try {
            request.setPhone(phone);
            request.setImei(imei);
            response = api.sendPhoneImei(request).execute().body();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
