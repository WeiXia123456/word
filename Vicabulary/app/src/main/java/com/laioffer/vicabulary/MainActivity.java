package com.laioffer.vicabulary;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;
        import androidx.navigation.fragment.NavHostFragment;
        import androidx.navigation.ui.NavigationUI;

        import android.app.FragmentManager;
        import android.app.FragmentTransaction;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;


        import com.google.android.material.bottomnavigation.BottomNavigationView;
        import com.google.android.material.navigation.NavigationView;
        import com.laioffer.vicabulary.database.DatabaseHelper;
        import com.laioffer.vicabulary.ui.user.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    public static DatabaseHelper vDb;
    private Toolbar myToolbar;
    private Fragment loginFragment = new LoginFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Test test test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController =navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navView,navController);
        NavigationUI.setupActionBarWithNavController(this,navController);

        vDb = new DatabaseHelper((this));
        vDb.onCreate(vDb.getReadableDatabase());

        // database
        vDb = new DatabaseHelper((this));
        vDb.onCreate(vDb.getReadableDatabase());



    }


    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

}

