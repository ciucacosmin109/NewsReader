package com.marius.data.store.remote;

import com.marius.data.store.remote.dto.ArticleListDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v2/top-headlines")
    Single<ArticleListDto> getNewsArticles(
            @Query("apiKey") String apiKey,
            @Query("language") String language
    );

}
