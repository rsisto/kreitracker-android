package kreitech.io.kreitrackerandroid.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sebastian on 24/03/16.
 */
/*
var UserSchema = new Schema({
   name: String,
   email: String,
   username: String,
   provider: String,
   hashed_password: String,
   salt: String,
   facebook: {},
   twitter: {},
   github: {},
   google: {}
});
 */

public class User implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String userName;

    @SerializedName("provider")
    private String provider;

    @SerializedName("password")
    private String password;

    @SerializedName("hashed_password")
    private String hashedPassword;

    @SerializedName("salt")
    private String salt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
