package kreitech.io.kreitrackerandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kreitech.io.kreitrackerandroid.responses.PhoneImeiResponse;

public class PhoneImeiActivity extends AppCompatActivity {

    private Facade facade;
    protected EditText phoneField;
    protected EditText imeiField;
    private Button sendButton;
    public String ERROR_PHONE_IMEI = "ERROR_PHONE_IMEI";
    public String REGISTERED_PHONE_IMEI = "REGISTERED_PHONE_IMEI";

    public PhoneImeiActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        facade = Facade.getInstance(this);

        setContentView(R.layout.activity_phone_imei);
        phoneField = (EditText)findViewById(R.id.prompt_phone);
        imeiField = (EditText)findViewById(R.id.prompt_imei);
        sendButton = (Button)findViewById(R.id.send);
    }

    public void sendPhoneImei(View button) {
        Object params[] = {
                phoneField.getText().toString(),
                imeiField.getText().toString()
        };

        new AsyncTask<Object, Void, Intent>() {

            @Override
            protected Intent doInBackground(Object... params) {
                PhoneImeiResponse response = facade.sendPhoneImei((String)params[0], (String)params[1]);
                Intent result = new Intent();
                if (response == null) {
                    result.putExtra(ERROR_PHONE_IMEI, getText(R.string.error_phone_imei));
                }else{
                    result.putExtra(REGISTERED_PHONE_IMEI, response);
                }
                return result;
            }

            @Override
            protected void onPostExecute(Intent intent) {
                if (intent.hasExtra(ERROR_PHONE_IMEI)) {
                    Toast.makeText(getBaseContext(), intent.getStringExtra(ERROR_PHONE_IMEI), Toast.LENGTH_SHORT).show();
                } else {
                    PhoneImeiResponse response = (PhoneImeiResponse)intent.getExtras().get(REGISTERED_PHONE_IMEI);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }.execute(params);
    }
}
