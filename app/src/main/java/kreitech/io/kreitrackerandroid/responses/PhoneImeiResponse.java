package kreitech.io.kreitrackerandroid.responses;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sebastian on 16/05/16.
 */
public class PhoneImeiResponse implements Serializable {

    @SerializedName("name")
    String name;

    @SerializedName("description")
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
