package com.example.gitbook.persistence


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gitbook.ui.UsersItem
import javax.inject.Singleton


@Database(entities = [UsersItem::class], exportSchema = false , version = 4)
abstract class AppDatabase: RoomDatabase() {

    @Singleton
    abstract fun getUserDao():UserDao


    companion object{
        const val DATABASE_NAME: String = "app_db"
    }

}