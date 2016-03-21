package kreitech.io.kreitrackerandroid.api;

/**
 * Created by rafael on 11/03/16.
 */
public class Tracker    {
    private String trackerId;
    private String name;
    private String phone;
    private String imei;

    public Tracker() {
    }

    public Tracker(String trackerId, String name, String phone, String imei) {
        this.trackerId = trackerId;
        this.name = name;
        this.phone = phone;
        this.imei = imei;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
