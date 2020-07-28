package com.payoda.android_11.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.payoda.android_11.entity.User
import com.payoda.android_11.repositories.UserDatabaseRepository
import kotlinx.coroutines.runBlocking

class ViewModelAddUser @ViewModelInject constructor(private val databaseRepository: UserDatabaseRepository) :
    ViewModel() {

    fun insert(user: User) {
        runBlocking {
            databaseRepository.insert(user)
        }
    }


}