package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.presentationmvvm.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchFragment searchFragment = SearchFragment_.builder().build();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_view, searchFragment)
                .commit();
    }
}
