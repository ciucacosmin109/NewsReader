package com.marius.data.store.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.marius.data.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticlesDao {
    @Query("SELECT * FROM articles")
    Flowable<List<ArticleEntity>> getAll();
    @Query("SELECT * FROM articles where id=:id")
    Single<ArticleEntity> get(int id);

    @Query("DELETE FROM articles where id=:id")
    Completable delete(int id);
    @Query("DELETE FROM articles")
    Completable deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<ArticleEntity> articles);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(ArticleEntity article);

    @Update
    Completable update(ArticleEntity article);

}
