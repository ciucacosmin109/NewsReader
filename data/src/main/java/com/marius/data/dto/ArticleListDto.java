package com.marius.data.dto;

import java.util.List;

public class ArticleListDto {
    public final int totalResults;
    public final List<ArticleDto> articles;

    public ArticleListDto(int totalResults, List<ArticleDto> articles) {
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
