package com.marius.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Database usually has
 * - entities
 * - converters
 * - dao
 * - migrations
 */
@Database(entities = {ArticleEntity.class}, version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract ArticlesDao articlesDao();
}
