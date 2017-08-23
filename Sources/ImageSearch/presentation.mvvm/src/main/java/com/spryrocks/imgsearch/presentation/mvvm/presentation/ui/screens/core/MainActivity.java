package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.presentationmvvm.R;
import com.example.presentationmvvm.databinding.FragmentSearchBinding;
import com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core.model.Image;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentSearchBinding binding = DataBindingUtil.setContentView(this, R.layout.fragment_search);
        Image image = new Image("Binding working!");
        binding.setImages(image);
    }
}
