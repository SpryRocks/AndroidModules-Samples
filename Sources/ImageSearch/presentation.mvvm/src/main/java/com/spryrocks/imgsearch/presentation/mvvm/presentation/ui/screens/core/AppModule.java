package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.content.Context;

import com.example.presentationmvvm.R;
import com.spryrocks.imgsearch.data.api.google.CustomSearchServiceConfiguration;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {
    private final Context context;

    AppModule(Context context) {
        this.context = context;
    }

    @Provides
    CustomSearchServiceConfiguration provideCustomSearchServiceConfiguration() {
        String key = context.getString(R.string.Config_GoogleCustomSearchApi_Key);
        String cx = context.getString(R.string.Config_GoogleCustomSearchApi_Cx);
        return new CustomSearchServiceConfiguration(key, cx);
    }
}
