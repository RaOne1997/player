package com.abhijeet.player;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.abhijeet.player.fragenment_vidoe.musicaudio;
import com.abhijeet.player.fragenment_vidoe.notffix;
import com.abhijeet.player.fragenment_vidoe.video;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mtabl;
    FrameLayout viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mtabl = findViewById( R.id.tsb );
        video fraf1 = new video();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
ft1.replace(R.id.pageview,fraf1,"");
        ft1.commit();
        mtabl.setOnNavigationItemSelectedListener( selectnava );

    }
            BottomNavigationView.OnNavigationItemSelectedListener selectnava = new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            video fraf1 = new video();
                            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                            ft1.replace( R.id.pageview, fraf1, "" );
                            ft1.commit();
                            return true;
                        case R.id.navigation_dashboard:
                            musicaudio fraf3 = new musicaudio();
                            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                            ft3.replace( R.id.pageview, fraf3, "" );
                            ft3.commit();
                            return true;
                        case R.id.navigation_notifications:
                            notffix fraf2 = new notffix();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace( R.id.pageview, fraf2, "" );
                            ft2.commit();
                            return true;
                    }


                    return false;
                }
            };

        }




