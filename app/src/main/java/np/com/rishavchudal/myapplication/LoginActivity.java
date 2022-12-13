package np.com.rishavchudal.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import np.com.rishavchudal.myapplication.dashboard.DashboardActivity;
import np.com.rishavchudal.myapplication.db.AppDatabase;
import np.com.rishavchudal.myapplication.db.User;
import np.com.rishavchudal.myapplication.db.UserDao;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "LoginActivity";
    private TextView tvDisplay1, tvDisplay2, tvDisplay3;
    private ImageView ivDisplay1;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "onCreate: ");
        tvDisplay1 = findViewById(R.id.tv_display_1);
        tvDisplay2 = findViewById(R.id.tv_display_2);
        tvDisplay3 = findViewById(R.id.tv_display_3);
        ivDisplay1 = findViewById(R.id.iv_display_1);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        tvDisplay1.setText("This is Android...");
        tvDisplay1.setTextColor(getColor(R.color.purple_200));
        tvDisplay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        LoginActivity.this,
                        "Display 1 is clicked",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(
                            LoginActivity.this,
                            "Email is empty",
                            Toast.LENGTH_SHORT
                    ).show();
                } else if (!email.matches("@")) { //TODO add valid regex
                    Toast.makeText(
                            LoginActivity.this,
                            "Email is not in correct format",
                            Toast.LENGTH_SHORT
                    ).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(
                            LoginActivity.this,
                            "Password is empty",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            LoginActivity.this,
                            "Login success",
                            Toast.LENGTH_SHORT
                    ).show();

                    //Writing to Shared Preferences
                    SharedPreferences sharedPreferences = getSharedPreferences(
                            Constants.SHARED_PREF_LOGIN,
                            Context.MODE_PRIVATE
                    );
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constants.KEY_USER_EMAIL, email);
                    editor.putString(Constants.KEY_USER_PASSWORD, password);
                    editor.putBoolean(Constants.KEY_IS_LOGGED_IN, true);
                    editor.apply();

                    //Writing to SqliteDatabase
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Getting database instance
                            AppDatabase db = Room.databaseBuilder(
                                    getApplicationContext(),
                                    AppDatabase.class,
                                    "amd.db"
                            ).build();

                            //Getting Dao instance
                            UserDao userDao = db.getUserDao();

                            //Instantiating User Entity
                            User user = new User();
                            user.email = email;
                            user.password = password;

                            userDao.insertUser(user);
                        }
                    }).start();

                    //Starting Activity
                    Intent intent = new Intent(
                            LoginActivity.this,
                            DashboardActivity.class
                    );
//                    UserCredentials userCredentials = new UserCredentials(email, password);
//                    intent.putExtra("user_credentials", userCredentials);
//                    intent.putExtra("user_email", email);
//                    intent.putExtra("user_password", password);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}