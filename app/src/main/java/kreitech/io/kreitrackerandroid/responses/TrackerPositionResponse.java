package kreitech.io.kreitrackerandroid.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sebastian on 16/05/16.
 *
 * {"success":true,"message":"Enjoy your token!","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIkX18iOnsic3RyaWN0TW9kZSI6dHJ1ZSwiZ2V0dGVycyI6e30sIl9pZCI6IjU3M2EwNjY2MTRjZjA1MTgxNTAwMDAwMSIsIndhc1BvcHVsYXRlZCI6ZmFsc2UsImFjdGl2ZVBhdGhzIjp7InBhdGhzIjp7Il9fdiI6ImluaXQiLCJ1c2VybmFtZSI6ImluaXQiLCJzYWx0IjoiaW5pdCIsImhhc2hlZF9wYXNzd29yZCI6ImluaXQiLCJuYW1lIjoiaW5pdCIsImVtYWlsIjoiaW5pdCIsInByb3ZpZGVyIjoiaW5pdCIsIl9pZCI6ImluaXQifSwic3RhdGVzIjp7ImRlZmF1bHQiOnt9LCJpbml0Ijp7Il9fdiI6dHJ1ZSwidXNlcm5hbWUiOnRydWUsInNhbHQiOnRydWUsImhhc2hlZF9wYXNzd29yZCI6dHJ1ZSwibmFtZSI6dHJ1ZSwiZW1haWwiOnRydWUsInByb3ZpZGVyIjp0cnVlLCJfaWQiOnRydWV9LCJtb2RpZnkiOnt9LCJyZXF1aXJlIjp7fX0sInN0YXRlTmFtZXMiOlsicmVxdWlyZSIsIm1vZGlmeSIsImluaXQiLCJkZWZhdWx0Il19fSwiaXNOZXciOmZhbHNlLCJfbWF4TGlzdGVuZXJzIjowLCJfZG9jIjp7Il9fdiI6MCwidXNlcm5hbWUiOiJzbHAiLCJzYWx0IjoiMjU0MjM2NzU5ODIzIiwiaGFzaGVkX3Bhc3N3b3JkIjoiNDA0ZDZlMGNmODNkYmIxMmVjMGM1OTA4MDcwMGI0ZmMwYTBiOTNhNCIsIm5hbWUiOiJTZWJhc3Rpw6FuIExhY3Vlc3RhIiwiZW1haWwiOiJzbGFjdWVzdGFAa3JlaXRlY2guaW8iLCJwcm92aWRlciI6ImxvY2FsIiwiX2lkIjoiNTczYTA2NjYxNGNmMDUxODE1MDAwMDAxIn0sIl9wcmVzIjp7InNhdmUiOltudWxsLG51bGwsbnVsbCxudWxsXX0sIl9wb3N0cyI6eyJzYXZlIjpbXX0sImlhdCI6MTQ2MzQyNDU4MiwiZXhwIjoxNDY0MDI0NTgyfQ.kRn3rJ6DCesdI8rt1YE6k66GfIFVQVEFSDJQ4Npdof4"}
 *
 */
public class TrackerPositionResponse implements Serializable {

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private String lon;

    @SerializedName("triggered")
    private Boolean triggered;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Boolean getTriggered() {
        return triggered;
    }

    public void setTriggered(Boolean triggered) {
        this.triggered = triggered;
    }
}
