package com.marius.data.store.local.mapper;

import com.marius.data.model.Article;
import com.marius.data.store.local.ArticleEntity;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleMapper implements Function<ArticleEntity, Article> {

    @Override
    public Article apply(ArticleEntity entity) {
        Article article = new Article();
        article.title = entity.title;
        article.description = entity.description;
        article.content = entity.content;
        article.imageUrl = entity.imageUrl;

        return article;
    }

}