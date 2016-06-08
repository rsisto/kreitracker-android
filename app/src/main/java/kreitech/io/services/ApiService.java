package kreitech.io.services;

import kreitech.io.kreitrackerandroid.models.AuthToken;
import kreitech.io.kreitrackerandroid.models.User;
import kreitech.io.kreitrackerandroid.responses.LoginResponse;
import kreitech.io.kreitrackerandroid.responses.PhoneImeiRequest;
import kreitech.io.kreitrackerandroid.responses.PhoneImeiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by sebastian on 24/03/16.
 */
public interface ApiService {

    @GET("users/{id}")
    public Call<User> getUser(@Path("id")String id);

    @POST("users")
    public Call<User> registerUser(@Body User user);

    @POST("authentication")
    public Call<LoginResponse> login(@Body User user);

    @POST("users/alarms/trackers")
    public Call<PhoneImeiResponse> sendPhoneImei(@Body PhoneImeiRequest request);


}
