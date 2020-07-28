package com.payoda.android_11.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.payoda.android_11.entity.User


@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User?)

    @get:Query("SELECT * FROM users")
    val allUsers: LiveData<MutableList<User?>?>?

    @Query("SELECT * FROM users WHERE id=:mobile")
    fun getUser(mobile: String?): LiveData<User?>?

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?): Int
}