package com.spryrocks.imgsearch.presentation.app;

import android.content.Context;

import com.spryrocks.imgsearch.data.api.google.CustomSearchServiceConfiguration;
import com.spryrocks.imgsearch.presentation.R;

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
}
