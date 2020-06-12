package com.example.gitbook.persistence

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.gitbook.ui.UsersItem
import javax.inject.Singleton


@Singleton
@Dao
interface UserDao {

    @Insert()
    fun insertUser(vararg usersItem: UsersItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(order: List<UsersItem>)

    @Delete
    fun deleteUser(vararg usersItem: UsersItem)

    @Query("DELETE FROM users")
    fun deleteAll()

    @Query("SELECT * from users")
    fun getAllUsers():LiveData<List<UsersItem>?>

    @Query("SELECT * FROM users")
    fun getAllPagedUsers(): DataSource.Factory<Int, UsersItem>

}