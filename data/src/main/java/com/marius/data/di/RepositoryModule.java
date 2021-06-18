package com.marius.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.marius.data.NewsRepository;
import com.marius.data.NewsRepositoryImpl;
import com.marius.data.store.local.NewsDatabase;
import com.marius.data.store.local.NewsLocalSource;
import com.marius.data.store.remote.HttpClientFactory;
import com.marius.data.store.remote.NewsRemoteSource;

import io.reactivex.annotations.NonNull;

public class RepositoryModule {
    private static final String DB_NAME = "News.db";
    private final Context context;
    private final HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;

    public RepositoryModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(
            provideNewsRemoteSource(),
            provideNewsLocalSource()
        );
    }

    NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
    NewsLocalSource provideNewsLocalSource() {
        NewsDatabase database = getInstance();
        return new NewsLocalSource(database.articlesDao());
    }

    NewsDatabase getInstance() {
        if (database != null) {
            return database;
        }

        synchronized (NewsDatabase.class) {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NewsDatabase.class,
                    DB_NAME
                ).build();
            }
        }
        return database;
    }
}
