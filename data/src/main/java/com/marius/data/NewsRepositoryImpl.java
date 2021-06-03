package com.marius.data;

import com.marius.data.mapper.NewsDtoToNewsMapper;
import com.marius.data.model.Article;
import com.marius.data.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .map(new NewsDtoToNewsMapper());
    }
}
