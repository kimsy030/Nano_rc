package com.example.smart_mode_lampes;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new ViewPagerAdapter(this));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_mainpage:
                    viewPager.setCurrentItem(0, false);
                    break;

                case R.id.page_home:
                    viewPager.setCurrentItem(1, false);
                    break;

                case R.id.page_control:
                    viewPager.setCurrentItem(2, false);
                    break;

                case R.id.page_status:
                    viewPager.setCurrentItem(3, false);
                    break;
            }
            return true;
        });

        //위치권한 허용 코드
        String[] permission_list = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        ActivityCompat.requestPermissions(MainActivity.this, permission_list, 1);

        //블루투스 활성화
        activeBluetooth();
    }


    private static class ViewPagerAdapter extends FragmentStateAdapter {
        MainpageFragment mainpageFragment;
        HomeFragment homeFragment;
        LightControlFragment lightControlFragment;
        ShowStatusFragment showStatusFragment;


        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    if (mainpageFragment == null) {
                        mainpageFragment = new MainpageFragment();
                    }

                    return mainpageFragment;

                case 1:
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                    }

                    return homeFragment;

                case 2:
                    if (lightControlFragment == null) {
                        lightControlFragment = new LightControlFragment();
                    }

                    return lightControlFragment;

                default:
                    if (showStatusFragment == null) {
                        showStatusFragment = new ShowStatusFragment();
                    }

                    return showStatusFragment;
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}