package com.marius.newsreader.articledetails.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.marius.data.NewsRepository;
import com.marius.data.model.Article;
import com.marius.newsreader.common.reactive.SingleLiveEvent;
import com.marius.newsreader.newslist.model.ArticleItemViewModel;

import java.util.Date;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class ArticleDetailsViewModel extends ViewModel {
    private final NewsRepository repository;
    private Disposable disposable;

    public final ObservableField<Integer> id;
    public final ObservableField<String> url;
    public final ObservableField<String> imageUrl;
    public final ObservableField<String> title;
    public final ObservableField<String> content;
    public final ObservableField<String> author;
    public final ObservableField<Date> publishedAt;
    public final ObservableBoolean isLoading;

    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public ArticleDetailsViewModel(NewsRepository repository) {
        this.repository = repository;

        id = new ObservableField<>();
        url = new ObservableField<>();
        imageUrl = new ObservableField<>();
        title = new ObservableField<>();
        content = new ObservableField<>();
        author = new ObservableField<>();
        publishedAt = new ObservableField<>();
        isLoading = new ObservableBoolean();

        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    public void initArticle(int id){
        isLoading.set(true);

        disposable = repository.getArticle(id)
            .subscribe(
                this::onArticleReceived,
                this::onArticleError
            );
    }
    private void onArticleReceived(Article article) {
        isLoading.set(false);

        id.set(article.id);
        url.set(article.url);
        imageUrl.set(article.imageUrl);
        title.set(article.title);
        content.set(article.content);
        author.set(article.author);
        publishedAt.set(article.publishedAt);
    }
    private void onArticleError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }
    public void openArticleLink() {
        openLink.setValue(this.url.get());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(disposable != null) {
            disposable.dispose();
        }
    }
}
