package com.example.githubrepositoryclnart.di

import android.content.Context
import androidx.room.Room
import com.example.data.data_source.local.LocalDataSource
import com.example.data.data_source.local.RepositoriesDatabase
import com.example.data.data_source.local.TrendingRepositoriesDao
import com.example.data.data_source.local.data_store.DataStorePreference
import com.example.githubrepositoryclnart.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RepositoriesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: RepositoriesDatabase) = database.trendingRepositoriesDao()

    @Singleton
    @Provides
    fun provideDataStorePreference(
        @ApplicationContext context: Context
    ) = DataStorePreference(context)

    @Singleton
    @Provides
    fun provideLocalDataSource(
        trendingRepositoriesDao: TrendingRepositoriesDao,
        dataStorePreference: DataStorePreference
    ) = LocalDataSource(trendingRepositoriesDao, dataStorePreference)
}