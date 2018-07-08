package com.bangunanbersejarah.masyarakat.bangunanbersejarah.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.FavoritFragment;
import com.bumptech.glide.Glide;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.R;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.BantenFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.JakartaFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.JawaBaratFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.JawaTengahFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.JawaTimurFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.TentangFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.YogyakartaFragment;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.fragment.MainFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    JSONObject userProfile;

    String userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        displaySelectedScreen(item.getItemId());

        return true;
    }

    public void displaySelectedScreen(int itemId){
        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                fragment = new MainFragment();
                break;
            case R.id.nav_prov_banten:
                fragment = new BantenFragment();
                break;
            case R.id.nav_prov_jakarta:
                fragment = new JakartaFragment();
                break;
            case R.id.nav_prov_jawabarat:
                fragment = new JawaBaratFragment();
                break;
            case R.id.nav_prov_jawatengah:
                fragment = new JawaTengahFragment();
                break;
            case R.id.nav_prov_jawatimur:
                fragment = new JawaTimurFragment();
                break;
            case R.id.nav_prov_yogyakarta:
                fragment = new YogyakartaFragment();
                break;
            case R.id.nav_favorit:
                fragment = new FavoritFragment();
                break;
            case R.id.nav_quiz:
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                break;
            case R.id.nav_tentang:
                fragment = new TentangFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
