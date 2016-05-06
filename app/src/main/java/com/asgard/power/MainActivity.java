package com.asgard.power;


import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.asgard.power.adapter.TabsPagerFragmentAdapter;
import com.asgard.power.fragments.RecycleFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomSheetBehavior behavior;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private FrameLayout frameSheet;
    private CoordinatorLayout coordinatorLayout;
    private View bottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initNavigationDrawer();
        initTabs();
        initBottomSheetBehavior();
    }



    private static void hideSheet(View bottomSheet, final BottomSheetBehavior behavior){
        bottomSheet.post(new Runnable() {
            @Override
            public void run() {
                behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
    }

    private void initBottomSheetBehavior() {
      //  RecycleFragment frag = (RecycleFragment )getSupportFragmentManager().findFragmentById(R.id.recyclefragment123456);


        frameSheet = (FrameLayout) findViewById(R.id.framesheet);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        bottomSheet = coordinatorLayout.findViewById(R.id.framesheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        Log.d("Sheet", "behavior " + behavior);
        hideSheet(bottomSheet,behavior);
        RecycleFragment.getInstance().setContext(this);
        RecycleFragment.getInstance().setBehaviorSheet(behavior, frameSheet);

        behavior.setBottomSheetCallback(new BehaviorController(behavior));


    }

    public  BottomSheetBehavior getBehavior(){
        return behavior;
    }

    public FrameLayout getFrameSheet(){
        return frameSheet;
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //То откуда
        drawer.closeDrawer(GravityCompat.START);
        //Класс "отвечающий" за иконку-гамбургер, синхронизирующий и связывающий navigation drawer и иконку.

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
    //    drawer.setDrawerListener(toggle);
        toggle.setHomeAsUpIndicator(R.drawable.hamburger);
        /**
         Сам момент синхронизации
         */
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /**
     * при нажатии кнопки "назад" мы не выходим из приложения
     * При условии открытого Navigation Drawer.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Поддержка тулбара.Насколько я понимаю, система принимает его как ActionBar , но кастомизированный
        //нами, обязательно к использованию.
        setSupportActionBar(toolbar);
        //Вытаскиваем иконку гамбургера.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Power");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        return true;
    }

}
