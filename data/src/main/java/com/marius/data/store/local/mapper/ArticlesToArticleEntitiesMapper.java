package com.marius.data.store.local.mapper;

import com.marius.data.model.Article;
import com.marius.data.store.local.ArticleEntity;
import com.marius.data.store.remote.dto.ArticleDto;
import com.marius.data.store.remote.dto.ArticleListDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToArticleEntitiesMapper implements Function<List<Article>, List<ArticleEntity>> {
    private final ArticleToArticleEntityMapper mapper = new ArticleToArticleEntityMapper();

    @Override
    public List<ArticleEntity> apply(List<Article> articles) {
        List<ArticleEntity> result = new ArrayList<>();

        for (Article article : articles) {
            result.add(mapper.apply(article));
        }
        return result;
    }

}