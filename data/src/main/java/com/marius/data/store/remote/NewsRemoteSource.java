package com.marius.data.store.remote;

import com.marius.data.model.Article;
import com.marius.data.store.remote.dto.ArticleListDto;
import com.marius.data.store.remote.mapper.NewsDtoToNewsMapper;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    //Don't copy this api key, use your own by registering here https://newsapi.org/register
    private static final String API_KEY = "e7f314bee8434f71b85e0254aeb97ee0";
    private static final String EN_LANGUAGE_FILTER = "en";

    @NonNull
    private final NewsApi newsApi;
    public NewsRemoteSource(@NonNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi
                .getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .map(new NewsDtoToNewsMapper())
                .subscribeOn(Schedulers.io());
    }
}
