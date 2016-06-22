package kreitech.io.services;

import android.support.v4.view.animation.LinearOutSlowInInterpolator;

import kreitech.io.kreitrackerandroid.api.TrackerPosition;
import kreitech.io.kreitrackerandroid.models.AuthToken;
import kreitech.io.kreitrackerandroid.models.LoginInformation;
import kreitech.io.kreitrackerandroid.models.User;
import kreitech.io.kreitrackerandroid.models.UserDevice;
import kreitech.io.kreitrackerandroid.responses.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    public Call<LoginResponse> login(@Body LoginInformation login);

    @POST("users/alarms/trackers")
    public Call<PhoneImeiResponse> sendPhoneImei(@Body PhoneImeiRequest request);

    @GET("trackerpositions/{id}")
    public Call<TrackerPositionResponse> getTrackerPosition(@Path("id")String id);

    @PUT("alarmsturn")
    public Call<AlarmResponse> alarm(@Body AlarmRequest request);


}
