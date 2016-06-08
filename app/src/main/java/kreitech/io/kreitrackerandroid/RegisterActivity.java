package kreitech.io.kreitrackerandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import kreitech.io.kreitrackerandroid.models.User;
import kreitech.io.services.ApiService;
import kreitech.io.services.KRestClient;

import static kreitech.io.kreitrackerandroid.LoginActivity.KEY_ERROR_MESSAGE;

public class RegisterActivity extends AppCompatActivity {

    private Facade facade;

    private Button mRegisterButton;
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText userNameField;
    private EditText emailField;
    private EditText passwordField;
    private EditText repeatPasswordField;

    public static final String REGISTERED_USER = "REGISTERED_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameField = (EditText)findViewById(R.id.first_name);
        lastNameField = (EditText)findViewById(R.id.last_name);
        userNameField = (EditText)findViewById(R.id.user_name);
        emailField = (EditText)findViewById(R.id.email);
        passwordField = (EditText)findViewById(R.id.password);
        repeatPasswordField = (EditText)findViewById(R.id.repeat_password);

        mRegisterButton = (Button) findViewById(R.id.register);
        mRegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userNameField.getText().toString();
                String name = firstNameField.getText().toString() + " " + lastNameField.getText().toString();
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();
                String repeatPassword = repeatPasswordField.getText().toString();
                performSignUp(username, name, email, password);
            }
        });

        this.facade = Facade.getInstance(this);
    }

    private void performSignUp(final String username, final String name, final String email, final String password) {
        new AsyncTask<Void, Void, Intent>() {

            @Override
            protected Intent doInBackground(Void... params) {
                User user = facade.registerUser(username, name, email, password);
                user.setPassword(password);
                Intent result = new Intent();
                if(user ==null){
                    result.putExtra(KEY_ERROR_MESSAGE,getString(R.string.error_processing_request));
                }else{
                    result.putExtra(REGISTERED_USER, user);
                }
                return result;
            }

            @Override
            protected void onPostExecute(Intent intent) {
                if (intent.hasExtra(KEY_ERROR_MESSAGE)) {
                    Toast.makeText(getBaseContext(), intent.getStringExtra(KEY_ERROR_MESSAGE), Toast.LENGTH_SHORT).show();
                } else {
                    User user = (User)intent.getExtras().get(REGISTERED_USER);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }

        }.execute();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
