package com.marius.data;

import android.annotation.SuppressLint;
import android.util.Log;

import com.marius.data.store.local.ArticleEntity;
import com.marius.data.store.local.NewsLocalSource;
import com.marius.data.store.local.mapper.ArticleEntitiesToArticlesMapper;
import com.marius.data.store.local.mapper.ArticlesToArticleEntitiesMapper;
import com.marius.data.store.remote.mapper.NewsDtoToNewsMapper;
import com.marius.data.model.Article;
import com.marius.data.store.remote.NewsRemoteSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

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
            .onErrorResumeNext(throwable -> localSource.getAll().firstOrError());
    }
}
