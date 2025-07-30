package com.example.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.data_source.local.entities.TrendingRepositoriesEntity

@Database(
    entities = [TrendingRepositoriesEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(RepositoriesTypeConverter::class)
abstract class RepositoriesDatabase: RoomDatabase() {
    abstract fun trendingRepositoriesDao(): TrendingRepositoriesDao
}