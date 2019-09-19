package com.samsung.hyunjaee.kim.boostcamp.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.samsung.hyunjaee.kim.boostcamp.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        mMainFragment = MainFragment.newInstance();
        fragmentTransaction
                .replace(R.id.main_frame, mMainFragment)
                .commit();
    }
}
