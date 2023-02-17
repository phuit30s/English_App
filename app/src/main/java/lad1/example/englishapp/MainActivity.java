package lad1.example.englishapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display(R.id.navigation_home);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                display(item.getItemId());
                return true;
            }
        });
    }
    void display(int id){
        Fragment fragment = null;

        switch (id){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_cources:
                fragment = new CoursesFragment();
                break;
            case R.id.navigation_quiz:
                fragment = new QuizFragment();
                break;
            case R.id.navigation_note:
                fragment = new NoteFragment();
                break;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment, fragment);
        ft.commit();
    }
}