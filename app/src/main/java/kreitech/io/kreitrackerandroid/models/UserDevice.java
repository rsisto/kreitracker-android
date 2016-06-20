package kreitech.io.kreitrackerandroid.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rafael on 17/06/16.
 */
public class UserDevice implements Serializable{

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("deviceType")
    private String deviceType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
