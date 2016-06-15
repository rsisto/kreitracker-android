package kreitech.io.kreitrackerandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import kreitech.io.kreitrackerandroid.api.KreitrackerApi;
import kreitech.io.kreitrackerandroid.api.Tracker;
import kreitech.io.kreitrackerandroid.api.TrackerPosition;
import kreitech.io.kreitrackerandroid.api.Utils;
import kreitech.io.kreitrackerandroid.responses.LoginResponse;
import kreitech.io.kreitrackerandroid.responses.TrackerPositionResponse;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private int mInterval = 50000; // 5 seconds by default, can be changed later


    private Handler mHandler;

    public static GoogleMap mMap;

    private Facade facade;

    private MapAsyncTask mMapTask = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        facade = Facade.getInstance(this);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mHandler = new Handler();
        startRepeatingTask();




    }


    /**
     * Update map every X seconds
     */
    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                updateStatus(); //this function can change value of mInterval.
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }


    };


    /**
     * Update map location
     */
    private void updateStatus() {


        mMapTask = new MapAsyncTask(this);
        mMapTask.execute();





        }




    /**
     * Star recurring task
     */
    void startRepeatingTask() {
        mStatusChecker.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng marcador = new LatLng(-34.905706, -56.1756192);
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

    }






    public class MapAsyncTask extends AsyncTask<String, Void, Intent> {

        private Facade facade;
        private Context context;


        MapAsyncTask( Context ctx) {
            context = ctx;
            facade = Facade.getInstance(context);
        }

        @Override
        protected Intent doInBackground(String... params) {
            final Intent intent = new Intent();

            //esto async
            TrackerPositionResponse tracker = facade.getTrackerPosition("1234");

            intent.putExtra("TP", tracker);

            return intent;
        }






        @Override
        protected void onPostExecute(final Intent intent) {
            //esto al principal
            if (mMap != null) {
                mMap.clear();

                TrackerPositionResponse tracker = (TrackerPositionResponse)intent.getExtras().get("TP");

                if (tracker != null) {
                    LatLng marcador = new LatLng(Double.valueOf(tracker.getLat()), Double.valueOf(tracker.getLon()));
                    mMap.addMarker(new MarkerOptions().position(marcador).title("tracker").snippet("juancarlos"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(marcador));
                }
            }

        }



    }























}
