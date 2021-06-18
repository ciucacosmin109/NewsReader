package com.marius.data.store.local.mapper;

import com.marius.data.model.Article;
import com.marius.data.store.local.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntitiesToArticlesMapper implements Function<List<ArticleEntity>, List<Article>> {
    private final ArticleEntityToArticleMapper mapper = new ArticleEntityToArticleMapper();

    @Override
    public List<Article> apply(List<ArticleEntity> entities) {
        List<Article> result = new ArrayList<>();

        for (ArticleEntity entity : entities) {
            result.add(mapper.apply(entity));
        }
        return result;
    }

}