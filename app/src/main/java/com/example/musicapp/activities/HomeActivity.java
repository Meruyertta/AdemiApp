package com.example.musicapp.activities;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.example.musicapp.R;
import com.example.musicapp.fragments.CartFragment;
import com.example.musicapp.fragments.CategoryFragment;
import com.example.musicapp.fragments.HomeFragment;
import com.example.musicapp.fragments.ProfileFragment;
import com.example.musicapp.recycleviews.drawer.DrawerItem;
import com.example.musicapp.recycleviews.drawer.DrawerModel;
import com.example.musicapp.recycleviews.drawer.DrawerRecycleViewAdapter;
import com.example.musicapp.recycleviews.drawer.DrawerSpaceItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity{

    BottomNavigationView navigationView;

    private static final int POS_HOME = 0;
    private static final int POS_MESSAGES = 0;
    private static final int POS_PROFILE = 0;
    private static final int POS_HELP = 0;
    private static final int POS_SETTINGS = 0;
    private static final int POS_LOGOUT = 0;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser currentUser=auth.getCurrentUser();

        if(currentUser==null){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(navListener);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();
//
//        slidingRootNav = new SlidingRootNavBuilder(this)
//                .withDragDistance(180)
//                .withRootViewScale(0.75f)
//                .withRootViewElevation(25)
//                .withToolbarMenuToggle(toolbar)
//                .withMenuOpened(false)
//                .withContentClickableWhenMenuOpened(false)
//                .withSavedState(savedInstanceState)
//                .withMenuLayout(R.layout.menu_drawer)
//                .inject();
//
//        screenIcons = loadScreenIcons();
//        screenTitles = loadScreenTitles();
//
//        DrawerRecycleViewAdapter drawerRecycleViewAdapter = new DrawerRecycleViewAdapter(Arrays.asList(
//                createItemFor(POS_HOME).setChecked(true),
//                createItemFor(POS_MESSAGES),
//                createItemFor(POS_PROFILE),
//                createItemFor(POS_HELP),
//                createItemFor(POS_SETTINGS),
//                new DrawerSpaceItem(260),
//                createItemFor(POS_LOGOUT)
//        ));
//        drawerRecycleViewAdapter.setListener((AdapterView.OnItemSelectedListener) this);
//
//        RecyclerView drawerlist = findViewById(R.id.drawer_list);
//        drawerlist.setNestedScrollingEnabled(false);
//        drawerlist.setLayoutManager(new LinearLayoutManager(this));
//        drawerlist.setAdapter(drawerRecycleViewAdapter);
//
//        drawerRecycleViewAdapter.setSelected(POS_HOME);
//
//    }
//
//    private DrawerItem createItemFor(int position){
//        return new DrawerModel(screenIcons[position], screenTitles[position])
//                .withIconTint(color(R.color.black))
//                .withTitleTint(color(R.color.black))
//                .withSelectedIconTint(color(R.color.mainLight))
//                .withSelectedTitleTint(color(R.color.mainLight));
//    }
//
//    @ColorInt
//    private int color(@ColorRes int res){
//        return ContextCompat.getColor(this, res);
//    }
//
//    private String[] loadScreenTitles() {
//        return getResources().getStringArray(R.array.id_activityScreenTitles);
//    }
//
//    private Drawable[] loadScreenIcons() {
//        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
//        Drawable[] icons = new Drawable[ta.length()];
//        for(int i = 0; i < ta.length(); i++){
//            int id = ta.getResourceId(i, 0);
//            if(id != 0){
//                icons[i] = ContextCompat.getDrawable(this, id);
//            }
//        }
//        ta.recycle();
//        return icons;
//    }
//
//    @Override
//    public void onBackPressed(){
//        finish();
//    }
//
//    @Override
//    public void onItemSelected(int position) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        if(position == POS_HOME){
//            HomeFragment homeFragment = new HomeFragment();
//            transaction.replace(R.id.fragment_container, homeFragment);
//        }
//        else if(position == POS_MESSAGES){
//            ProfileFragment profileFragment = new ProfileFragment();
//            transaction.replace(R.id.fragment_container, profileFragment);
//        }
//        else if(position == POS_PROFILE){
//            ProfileFragment profileFragment = new ProfileFragment();
//            transaction.replace(R.id.fragment_container, profileFragment);
//        }
//
//       else if(position == POS_HELP){
//            ProfileFragment profileFragment = new ProfileFragment();
//            transaction.replace(R.id.fragment_container, profileFragment);
//        }
//       else if(position == POS_SETTINGS){
//            ProfileFragment profileFragment = new ProfileFragment();
//            transaction.replace(R.id.fragment_container, profileFragment);
//        }
//
//       else if(position == POS_LOGOUT){
//           finish();
//        }
//
//       slidingRootNav.closeMenu();
//       transaction.addToBackStack(null);
//       transaction.commit();
    }
    


    //Navbar bottom
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = new HomeFragment();
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.nav_category:
                    selectedFragment = new CategoryFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };


}