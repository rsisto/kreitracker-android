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
    Integer imei;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }
}
