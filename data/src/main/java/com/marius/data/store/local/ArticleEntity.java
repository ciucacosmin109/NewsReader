package com.marius.data.store.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.marius.data.store.local.converter.DateConverter;

import java.util.Date;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "articles")
@TypeConverters({DateConverter.class})
public class ArticleEntity {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public String title;
    public String url;
    public String imageUrl;
    public String content;
    public String description;
    public String author;
    public Date publishedAt;
}
