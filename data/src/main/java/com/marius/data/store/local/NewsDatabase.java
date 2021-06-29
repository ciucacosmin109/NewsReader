package com.marius.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.marius.data.store.local.converter.DateConverter;

/**
 * Database usually has
 * - entities
 * - converters
 * - dao
 * - migrations
 */
@Database(entities = {ArticleEntity.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class NewsDatabase extends RoomDatabase {
    public abstract ArticlesDao articlesDao();
}
