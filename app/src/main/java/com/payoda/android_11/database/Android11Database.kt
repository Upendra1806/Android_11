package com.payoda.android_11.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.payoda.android_11.dao.UserDao
import com.payoda.android_11.entity.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class Android11Database : RoomDatabase() {
    abstract fun userDao(): UserDao
}