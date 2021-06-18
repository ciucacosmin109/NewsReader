package com.marius.data.store.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "articles")
public class ArticleEntity {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public String title;
    public String imageUrl;
    public String content;
    public String description;

}
