package com.payoda.android_11.viewmodels

import android.content.SharedPreferences
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.payoda.android_11.entity.User
import com.payoda.android_11.repositories.UserDatabaseRepository

class ViewModelUserList @ViewModelInject constructor(
    val sharedPreferences: SharedPreferences,
    val databaseRepository: UserDatabaseRepository,
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {

    lateinit var userdata: LiveData<MutableList<User?>?>

    init {
        getUserList();
        sharedPreferences.edit().putString("APP_ID", "com.payoda.android11").commit();
        Log.v("APP_ID", sharedPreferences.getString("APP_ID", "APP"));
    }

    fun getUserList() {
        userdata = databaseRepository.allUsers!!
    }

}