package kreitech.io.kreitrackerandroid.api;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rafael on 11/03/16.
 */
public class KreitrackerApi  {




    public static void getTracker(String trackerId, final ResponseCallback<Tracker> callback){
        String restUrl = Utils.constructRestUrlForGetTrackerId(trackerId);
        new KreitrackerAsyncTask(restUrl, null,KreitrackerAsyncTask.METHOD_GET,new RestTaskCallback (){
            @Override
            public void onTaskComplete(String response){
                Tracker tracker = Utils.parseResponseAsTracker(response);
                callback.onDataReceived(tracker);
            }
        }).execute();
    }

    public static void getTrackerPosition(String trackerId, final ResponseCallback<TrackerPosition> callback){
        String restUrl = Utils.constructRestUrlForGetTrackerPosition(trackerId);
        new KreitrackerAsyncTask(restUrl, null,KreitrackerAsyncTask.METHOD_GET,new RestTaskCallback (){
            @Override
            public void onTaskComplete(String response){
                TrackerPosition tracker = Utils.parseResponseAsTrackerPosition(response);
                callback.onDataReceived(tracker);
            }
        }).execute();
    }



    /**
     * Class definition for a callback to be invoked when the response data for the
     * GET call is available.
     */
    public static abstract class ResponseCallback<ApiObject>{

        /**
         * Called when the response data for the REST call is ready. <br/>
         * This method is guaranteed to execute on the UI thread.
         *
         * @param profile The {@code Profile} that was received from the server.
         */
        public abstract void onDataReceived(ApiObject profile);

    /*
     * Additional methods like onPreGet() or onFailure() can be added with default implementations.
     * This is why this has been made and abstract class rather than Interface.
     */
    }




}
