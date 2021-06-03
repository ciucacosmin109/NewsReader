package com.marius.data.remote;

import com.marius.data.dto.ArticleListDto;

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

    public Single<ArticleListDto> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io());
    }
}
