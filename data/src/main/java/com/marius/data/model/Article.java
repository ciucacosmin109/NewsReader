package com.marius.data.model;

import io.reactivex.annotations.NonNull;

public class Article {
    public String imageUrl;
    public String title;
    public String content;
    public String description;

    public Article() { }
    public Article(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
