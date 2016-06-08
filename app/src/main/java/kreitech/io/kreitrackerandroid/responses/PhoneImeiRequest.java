package kreitech.io.kreitrackerandroid.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sebastian on 16/05/16.
 */
public class PhoneImeiRequest implements Serializable {

    @SerializedName("phone")
    String phone;

    @SerializedName("imei")
    String imei;

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
