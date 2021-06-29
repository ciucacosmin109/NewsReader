package com.marius.data;

import com.marius.data.store.local.NewsLocalSource;
import com.marius.data.model.Article;
import com.marius.data.store.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {
    private final NewsRemoteSource remoteSource;
    private final NewsLocalSource localSource;

    public NewsRepositoryImpl(
            NewsRemoteSource remoteSource,
            NewsLocalSource localSource
    ) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    @Override @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
            .doOnSuccess(articles -> localSource.replaceAll(articles).subscribe())
            .compose(articles -> localSource.getAll().firstOrError());
    }

    @Override @NonNull
    public Single<Article> getArticle(int id) {
        return localSource.get(id);
    }
}
