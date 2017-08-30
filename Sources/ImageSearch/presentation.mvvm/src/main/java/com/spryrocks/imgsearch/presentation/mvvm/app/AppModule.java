package com.spryrocks.imgsearch.presentation.mvvm.app;

import android.content.Context;

import com.example.presentationmvvm.R;
import com.spryrocks.imgsearch.data.api.google.CustomSearchServiceConfiguration;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    CustomSearchServiceConfiguration provideCustomSearchServiceConfiguration() {
        String key = context.getString(R.string.Config_GoogleCustomSearchApi_Key);
        String cx = context.getString(R.string.Config_GoogleCustomSearchApi_Cx);
        return new CustomSearchServiceConfiguration(key, cx);
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
