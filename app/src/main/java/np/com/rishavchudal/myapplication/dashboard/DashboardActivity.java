package np.com.rishavchudal.myapplication.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import np.com.rishavchudal.myapplication.Constants;
import np.com.rishavchudal.myapplication.R;
import np.com.rishavchudal.myapplication.dashboard.fragments.HomeFragment;
import np.com.rishavchudal.myapplication.dashboard.fragments.ProfileFragment;
import np.com.rishavchudal.myapplication.dashboard.fragments.PurchasedFragment;

public class DashboardActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private PurchasedFragment purchasedFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        homeFragment = HomeFragment.newInstance();
        purchasedFragment = PurchasedFragment.newInstance();
        profileFragment = ProfileFragment.newInstance();

        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        loadFragment(homeFragment);
                        break;

                    case R.id.purchased:
                        loadFragment(purchasedFragment);
                        break;

                    case R.id.profile:
                        loadFragment(profileFragment);
                        break;

                    default:
                        break;
                }
                return false;
            }
        });





        //Reading from Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(
                Constants.SHARED_PREF_LOGIN,
                Context.MODE_PRIVATE
        );
        String email = sharedPreferences
                .getString(Constants.KEY_USER_EMAIL, "");
        String password = sharedPreferences
                .getString(Constants.KEY_USER_PASSWORD, "");

        Toast.makeText(
                DashboardActivity.this,
                "Email ::: " + email + ", Password ::: " + password,
                Toast.LENGTH_SHORT
        ).show();

//        Intent intent = getIntent();
//        UserCredentials userCredentials = (UserCredentials) intent
//                .getSerializableExtra("user_credentials");
//        String userData = "Email ::: " +
//                userCredentials.getUserEmail() +
//                ", Password ::: " +
//                userCredentials.getUserPassword();
//        Toast.makeText(
//                DashboardActivity.this,
//                userData,
//                Toast.LENGTH_LONG
//        ).show();
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, fragment);
        fragmentTransaction.commit();
    }


}