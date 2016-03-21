package kreitech.io.kreitrackerandroid.api;

import java.util.Date;

/**
 * Created by rafael on 11/03/16.
 */
public class TrackerPosition {
    private String trackerId;
    private double lat;
    private double lon;
    private String updatedAt;

    public TrackerPosition() {
    }

    public TrackerPosition(String trackerId, double lat, double lon, String updatedAt) {
        this.trackerId = trackerId;
        this.lat = lat;
        this.lon = lon;
        this.updatedAt = updatedAt;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
