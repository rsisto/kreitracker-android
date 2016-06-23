package kreitech.io.kreitrackerandroid.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sebastian on 16/05/16.
 */
public class AlarmResponse implements Serializable {

    @SerializedName("kOn")
    private Boolean kOn;

    public Boolean getkOn() {
        return kOn;
    }

    public void setkOn(Boolean kOn) {
        this.kOn = kOn;
    }
}
