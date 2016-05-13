package kreitech.io.services;

import kreitech.io.kreitrackerandroid.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sebastian on 24/03/16.
 */
public interface ApiService {

    @GET("users/{id}")
    public Call<User> getUser(@Path("id")String id);

    @POST("users")
    public Call<User> registerUser(@Body User user);

    @POST("authentication")
    public Call<User> login(@Body User user);
}
