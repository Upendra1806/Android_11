package com.payoda.android_11.repositories

import androidx.lifecycle.LiveData
import com.payoda.android_11.dao.UserDao
import com.payoda.android_11.entity.User
import javax.inject.Inject

class UserDatabaseRepository @Inject constructor(var userDao: UserDao) {

    val allUsers: LiveData<MutableList<User?>?>? = userDao.allUsers

    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}