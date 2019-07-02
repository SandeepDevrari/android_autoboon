package in.autoboon.autoboon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import javax.inject.Inject;

import in.autoboon.autoboon.fragments.Home;
import in.autoboon.autoboon.fragments.UserProfile;
import in.autoboon.autoboon.fragments.sFragment;
import in.autoboon.autoboon.helper.OnCallTwo;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnCallTwo<Integer,sFragment> {

    private FragmentManager fragmentManager;
    private int doublePressToExit=1;
    private int currentSelectedMenuResId;
    private NavigationView navigationView;

    @Inject
    public AutoboonApp autoboonApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((AutoboonApp)getApplication()).getAppComponentDagger().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();

        fragmentManager=getSupportFragmentManager();
        displayFragment(2,new Home());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }

    private void setUpUI() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        //ActionBar actionBar=getSupportActionBar();
//        if(actionBar!=null){
//            actionBar.setDisplayShowHomeEnabled(true);
//            actionBar.setLogo(R.drawable.logo);
//            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayShowTitleEnabled(false);
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        clearSelectedMenu();

//        if (doublePressToExit <=1) {
//            if (doublePressToExit ==0) {
//                super.onBackPressed();
//            }else {
//                Toast.makeText(autoboonApp, getResources().getString(R.string.exit_msg), Toast.LENGTH_SHORT).show();
//                --doublePressToExit;
//            }
//        } else {
//            --doublePressToExit;
            super.onBackPressed();
        //}
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_profile:{
                onCall(1,new UserProfile());
                break;
            }
            case R.id.nav_login:{
                startActivity(new Intent(autoboonApp,LoginActivity.class));
                break;
            }
            case R.id.nav_search:{
                onCall(3,new Home());
                break;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCall(Integer one, sFragment two) {
        displayFragment(one,two);
    }

    private void displayFragment(Integer one, sFragment fragment) {
        fragment.setCallTwo(this);
        switch (one){
            case 1:{
                fragmentManager.beginTransaction().add(R.id.main_frame_lay,fragment).addToBackStack(fragment.getTag()).commit();
                if(doublePressToExit==0) {
                    doublePressToExit=1;
                    ++doublePressToExit;
                }else{
                    ++doublePressToExit;
                }
                break;
            }
            case 2:{
                fragmentManager.beginTransaction().replace(R.id.main_frame_lay,fragment).commit();
                //isAnyFragmentActive=true;
                break;
            }
            case 3:{
                for(int i=0;i<fragmentManager.getBackStackEntryCount();++i){
                    fragmentManager.popBackStack();
                }
                fragmentManager.beginTransaction().replace(R.id.main_frame_lay,fragment).commit();
                doublePressToExit=1;
                clearSelectedMenu();
                break;
            }
            case 4:{
                for(int i=0;i<fragmentManager.getBackStackEntryCount();++i){
                    fragmentManager.popBackStack();
                }
                fragmentManager.beginTransaction().replace(R.id.main_frame_lay,fragment).commit();
                doublePressToExit=1;
                finish();
                break;
            }
            default:{
                break;
            }
        }
    }
    private void clearSelectedMenu() {
        if(currentSelectedMenuResId!=0) {
            navigationView.getMenu().findItem(currentSelectedMenuResId).setChecked(false);
            currentSelectedMenuResId=0;
        }
    }
}
