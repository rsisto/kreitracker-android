package kreitech.io.kreitrackerandroid;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import kreitech.io.kreitrackerandroid.models.AuthToken;
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

    private static final String FACADE_PREF = "Facade" ;
    private static Facade instance = null;
    private KRestClient client;
    private ApiService api;
    private boolean authenticated = false;

    private Facade() {
        this.client = new KRestClient();
        this.api = client.getApiService();
    }

    public static Facade getInstance(Context ctx) {
        if (instance == null) {
            instance = new Facade();
        }
        //TODO: get the token from AccountManager


        SharedPreferences sp = ctx.getSharedPreferences(FACADE_PREF,0);
        String token = sp.getString("token", null);
        if(token!=null && !instance.authenticated){
            //Set the user as authenticated.

            instance.api = instance.client.getApiService(token);
            instance.authenticated = true;
        }
        //TODO: if token is invalid, we must log out the user.
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
            //TODO: manage error when there's no connection to the server.
        }
    }

    public LoginResponse login(String username, String password, Context ctx) {
        User user = new User();
        LoginResponse response;
        try {
            user.setUserName(username);
            user.setPassword(password);
            response = api.login(user).execute().body();
            String token = response.getToken();
            //Store the token in Sharedpreferences.
            SharedPreferences sp = ctx.getSharedPreferences(FACADE_PREF,0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("token",token);
            edit.commit();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PhoneImeiResponse sendPhoneImei(String phone, String imei) {
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
