package com.asgard.power;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
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
import android.view.MotionEvent;
import android.view.View;

import com.asgard.power.adapter.TabsPagerFragmentAdapter;
import com.asgard.power.fragments.RecycleFragment;
import com.asgard.power.interfaces.BottomSheetCallbackAdapter;
import com.asgard.power.interfaces.BottomSheetSaveState;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomSheetSaveState {
    private static BottomSheetBehavior behavior;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private CoordinatorLayout coordinatorLayout;
    private View bottomSheet;
    private boolean isExpanded;
    private BottomSheetCallbackAdapter subscriber;
    private BottomBar bottomBar;
    private RvWordsAdapter adapter;


    public RvWordsAdapter getWordsAdapter() {
        return this.adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("adapter", "onCreate:" + adapter);

        if (adapter instanceof BottomSheetCallbackAdapter) {
            subscriber = (BottomSheetCallbackAdapter) adapter;
        } else {
            throw new IllegalStateException("Subscriber must implement Bottom Sheet Callback Adapter interface");
        }
        setSubscriber(adapter);
        initToolbar();
        initNavigationDrawer();
        initTabs();
        initBottomSheetBehavior();

        // initBottomBar(savedInstanceState);
    }

    private void initBottomBar(Bundle savedInstanceState) {
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.bottom_bar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

    }

    public void setSubscriber(BottomSheetCallbackAdapter bottomSheetCallbackAdapter) {
        subscriber = bottomSheetCallbackAdapter;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        bottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void saveState(int state) {
        if (isExpanded) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        isExpanded = !isExpanded;


    }


    private void initBottomSheetBehavior() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        bottomSheet = coordinatorLayout.findViewById(R.id.framesheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        Log.d("Sheet", "behavior " + behavior);


        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                saveState(newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


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

        setSupportActionBar(toolbar);
        //Вытаскиваем иконку гамбургера.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Power");
        toolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
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