package com.marius.data.model;

import java.util.Date;

import io.reactivex.annotations.NonNull;

public class Article {
    public final Integer id;
    public final String title;
    public final String url;
    public final String imageUrl;
    public final String content;
    public final String description;
    public final String author;
    public final Date publishedAt;

    public Article(
        Integer id,
        @NonNull String title,
        @NonNull String url,
        @NonNull String imageUrl,
        @NonNull String content,
        @NonNull String description,
        @NonNull String author,
        @NonNull Date publishedAt
    ) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
        this.url = url;
        this.author = author;
        this.publishedAt = publishedAt;
    }
}
