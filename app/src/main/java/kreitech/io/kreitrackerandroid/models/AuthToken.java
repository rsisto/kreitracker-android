package kreitech.io.kreitrackerandroid.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rafael on 18/05/16.
 */
public class AuthToken {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
