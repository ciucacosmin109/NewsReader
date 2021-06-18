package com.marius.data.store.local;

import com.marius.data.model.Article;
import com.marius.data.store.local.mapper.ArticleEntitiesToArticlesMapper;
import com.marius.data.store.local.mapper.ArticleEntityToArticleMapper;
import com.marius.data.store.local.mapper.ArticleToArticleEntityMapper;
import com.marius.data.store.local.mapper.ArticlesToArticleEntitiesMapper;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalSource {
    private final ArticlesDao dao;
    public NewsLocalSource(ArticlesDao dao) {
        this.dao = dao;
    }

    public Flowable<List<Article>> getAll() {
        return dao.getAll()
                .map(new ArticleEntitiesToArticlesMapper())
                .subscribeOn(Schedulers.io());
    }
    public Completable saveAll(List<Article> articles) {
        return dao.insertAll(new ArticlesToArticleEntitiesMapper().apply(articles))
                .subscribeOn(Schedulers.io());
    }
    public Completable replaceAll(List<Article> articles) {
        return dao.deleteAll()
                .andThen(this.saveAll(articles))
                .subscribeOn(Schedulers.io());
    }
}
