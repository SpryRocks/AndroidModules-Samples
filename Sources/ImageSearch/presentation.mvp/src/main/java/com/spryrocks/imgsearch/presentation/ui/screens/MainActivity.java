package com.spryrocks.imgsearch.presentation.ui.screens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.screens.search.SearchFragment_;

import org.androidannotations.annotations.EActivity;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_view, SearchFragment_.builder().build())
                    .commit();
        }
    }

}
