package com.marius.newsreader;

import android.app.Application;

import com.marius.data.di.RepositoryModule;

public class NewsReaderApplication extends Application {

    //move along, will be replaced with Dagger later
    private static RepositoryModule repoModule;

    @Override
    public void onCreate() {
        super.onCreate();

        NewsReaderApplication.repoModule = new RepositoryModule(this);
    }

    public static RepositoryModule getRepoProvider() {
        return repoModule;
    }
}