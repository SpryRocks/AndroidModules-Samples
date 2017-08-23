package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.presentationmvvm.R;

import org.androidannotations.annotations.EActivity;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            SearchFragment fragment = SearchFragment_.builder().build();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_view, fragment)
                    .commit();
        }
    }
}