package com.marius.data.store.local.mapper;

import com.marius.data.model.Article;
import com.marius.data.store.local.ArticleEntity;
import com.marius.data.store.remote.dto.ArticleDto;
import com.marius.data.store.remote.dto.ArticleListDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleEntityMapper implements Function<Article, ArticleEntity> {

    @Override
    public ArticleEntity apply(Article article) {
        ArticleEntity entity = new ArticleEntity();
        entity.id = article.id;
        entity.title = article.title;
        entity.description = article.description;
        entity.content = article.content;
        entity.imageUrl = article.imageUrl;
        entity.url = article.url;
        entity.author = article.author;
        entity.publishedAt = article.publishedAt;

        return entity;
    }

}