package com.marius.data;

import androidx.annotation.NonNull;

import com.marius.data.model.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {
    @NonNull
    Single<List<Article>> getNewsArticles();

    @NonNull
    Single<Article> getArticle(int id);
}
