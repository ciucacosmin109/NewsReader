package com.marius.newsreader.common;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.marius.data.NewsRepository;
import com.marius.newsreader.NewsReaderApplication;
import com.marius.newsreader.articledetails.model.ArticleDetailsViewModel;
import com.marius.newsreader.newslist.model.NewsListViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory  implements ViewModelProvider.Factory {
    private final Application application;
    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @SuppressWarnings("unchecked")
    @NotNull @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        NewsRepository repo = NewsReaderApplication.getRepoProvider().provideNewsRepository();

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            return (T) new NewsListViewModel(application, repo);
        }
        if (modelClass.isAssignableFrom(ArticleDetailsViewModel.class)) {
            return (T) new ArticleDetailsViewModel(repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}