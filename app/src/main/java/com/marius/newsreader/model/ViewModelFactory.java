package com.marius.newsreader.model;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.marius.data.NewsRepository;
import com.marius.newsreader.NewsReaderApplication;

public class ViewModelFactory  implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repo = NewsReaderApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsListViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}