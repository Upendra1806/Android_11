package com.payoda.android_11.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.payoda.android_11.entity.User
import com.payoda.android_11.repositories.UserDatabaseRepository

class ViewModelUserList @ViewModelInject constructor(
    val databaseRepository: UserDatabaseRepository,
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {

    lateinit var userdata: LiveData<MutableList<User?>?>

    init {
        getUserList();
    }

    fun getUserList() {
        userdata = databaseRepository.allUsers!!
    }

}