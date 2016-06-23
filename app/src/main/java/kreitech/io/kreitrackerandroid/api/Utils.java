package kreitech.io.kreitrackerandroid.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rafael on 11/03/16.
 */
public class Utils {

    //TODO: this should be parameterized
    public static final String BASE_URL = "http://192.168.0.102:8080/api/";
    public static final String TRACKER_ID = "56e35a39600a830c51000001";
    private static final String GET_TRACKER_POSITION = BASE_URL + "trackerpositions/%s";
    private static final String GET_TRACKER = BASE_URL + "trackers/%s";

    public static String constructRestUrlForGetTrackerId(String trackerId) {
        return String.format(GET_TRACKER, trackerId);
    }

    public static String constructRestUrlForGetTrackerPosition(String trackerId) {
        return String.format(GET_TRACKER_POSITION, trackerId);
    }

    public static Tracker parseResponseAsTracker(String response){
        try {
            JSONObject data = new JSONObject(response);
            Tracker t = new Tracker();
            t.setTrackerId(data.getString("_id"));
            t.setName(data.getString("name"));
            t.setImei(data.getString("imei"));
            t.setPhone(data.getString("phone"));
            return t;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static TrackerPosition parseResponseAsTrackerPosition(String response) {
        try {
            JSONObject data = new JSONObject(response);
            TrackerPosition t = new TrackerPosition();
            t.setTrackerId(data.getString("trackerId"));
            t.setLat(data.getDouble("lat"));
            t.setLon(data.getDouble("lon"));
            t.setUpdatedAt(data.getString("created_at"));
            return t;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


}
