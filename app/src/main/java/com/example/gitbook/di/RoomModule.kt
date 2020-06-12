package com.example.gitbook.di

import android.app.Application
import androidx.room.Room
import com.example.gitbook.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME).allowMainThreadQueries()
//            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }


}