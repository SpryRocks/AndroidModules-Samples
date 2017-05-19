package com.spryrocks.imgsearch.data.api;

import android.util.Base64;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {
    private List<Interceptor> interceptors;

    protected ApiBase() {
        this.interceptors = new ArrayList<>();
    }

    @SuppressWarnings("WeakerAccess")
    protected void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    protected void addLoggingInterceptor(HttpLoggingInterceptor.Level level) {
        addInterceptor(new HttpLoggingInterceptor().setLevel(level));
    }

    protected <T> T createRetrofitApi(String url, Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesHttpClient())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient providesHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().
                connectTimeout(30, TimeUnit.SECONDS).
                readTimeout(30, TimeUnit.SECONDS);

        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }

    @SuppressWarnings("unused")
    protected String createBasicAuthHeader(String userName, String password) {
        String credentials = userName + ":" + password;
        return "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }
}
