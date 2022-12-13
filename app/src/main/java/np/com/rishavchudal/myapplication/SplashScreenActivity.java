package np.com.rishavchudal.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import np.com.rishavchudal.myapplication.dashboard.DashboardActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences sharedPreferences =
                getSharedPreferences(Constants.SHARED_PREF_LOGIN, Context.MODE_PRIVATE);
        boolean isLoggedIn =
                sharedPreferences.getBoolean(Constants.KEY_IS_LOGGED_IN, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (isLoggedIn) {
                    intent = new Intent(
                            SplashScreenActivity.this,
                            DashboardActivity.class
                    );
                } else {
                    intent = new Intent(
                            SplashScreenActivity.this,
                            LoginActivity.class
                    );
                }
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}