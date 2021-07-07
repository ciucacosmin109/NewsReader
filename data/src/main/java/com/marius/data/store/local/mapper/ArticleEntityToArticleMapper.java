package com.marius.data.store.local.mapper;

import com.marius.data.model.Article;
import com.marius.data.store.local.ArticleEntity;

import java.util.Date;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleMapper implements Function<ArticleEntity, Article> {

    @Override
    public Article apply(ArticleEntity entity) {
        return new Article(
            entity.id,
            entity.title != null ? entity.title : "", //Adding default values for business model
            entity.url != null ? entity.url : "",
            entity.imageUrl != null ? entity.imageUrl : "",
            entity.content != null ? entity.content : "",
            entity.description != null ? entity.description : "",
            entity.author != null ? entity.author : "",
            entity.publishedAt != null ? entity.publishedAt : new Date()
        );
    }

}