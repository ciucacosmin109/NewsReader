package com.marius.data.store.remote.mapper;

import com.marius.data.store.remote.dto.ArticleDto;
import com.marius.data.store.remote.dto.ArticleListDto;
import com.marius.data.model.Article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleListDtoToArticlesMapper implements Function<ArticleListDto, List<Article>> {

    @Override
    public List<Article> apply(ArticleListDto articleDtos) {
        List<Article> articles = new ArrayList<>();

        for (ArticleDto dto : articleDtos.articles) {
            Article article = new Article(
                    null,
                    dto.title != null ? dto.title : "", //Adding default values for business model
                    dto.url != null ? dto.url : "",
                    dto.urlToImage != null ? dto.urlToImage : "",
                    dto.content != null ? dto.content : "",
                    dto.description != null ? dto.description : "",
                    dto.author != null ? dto.author : "",
                    dto.publishedAt != null ? dto.publishedAt : new Date()
            );

            articles.add(article);
        }

        return articles;
    }

}
