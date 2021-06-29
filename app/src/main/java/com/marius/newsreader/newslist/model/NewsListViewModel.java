package com.marius.newsreader.newslist.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.marius.data.NewsRepository;
import com.marius.newsreader.common.handler.ArticleItemHandler;
import com.marius.newsreader.newslist.model.mapper.ArticlesToArticleItemsVmMapper;
import com.marius.newsreader.common.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver, ArticleItemHandler {
    private final static String LINK = "https://newsapi.org/";

    private final NewsRepository repository;
    private Disposable disposable;

    public PublishSubject<ArticleItemViewModel> events;

    public final ObservableList<ArticleItemViewModel> items;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public NewsListViewModel(Application application, NewsRepository repository) {
        super(application);
        this.repository = repository;
        this.events = PublishSubject.create();

        this.items = new ObservableArrayList<>();
        this.isLoading = new ObservableBoolean();
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        if((disposable == null || !disposable.isDisposed()) && items.isEmpty()){
            isLoading.set(true);
            this.items.clear();
            disposable = repository.getNewsArticles()
                    .map(new ArticlesToArticleItemsVmMapper())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            this::onNewsArticlesReceived,
                            this::onNewsArticlesError
                    );
        }
    }
    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        isLoading.set(false);
        this.items.addAll(articles);
        resultText.set("Fetched: " + articles.size());
    }
    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    @Override
    public void onItemSelected(ArticleItemViewModel item) {
        events.onNext(item);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(disposable != null) {
            disposable.dispose();
        }
    }
}
