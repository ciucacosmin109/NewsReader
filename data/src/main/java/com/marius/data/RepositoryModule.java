package com.marius.data;

import android.app.Application;
import android.content.Context;

import com.marius.data.remote.HttpClientFactory;
import com.marius.data.remote.NewsRemoteSource;

import io.reactivex.annotations.NonNull;

public class RepositoryModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    public RepositoryModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
