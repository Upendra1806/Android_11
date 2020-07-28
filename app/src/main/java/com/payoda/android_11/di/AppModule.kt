package com.payoda.android_11.di

import android.content.Context
import androidx.room.Room
import com.payoda.android_11.dao.UserDao
import com.payoda.android_11.database.Android11Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): Android11Database {
        return Room.databaseBuilder(context, Android11Database::class.java, "android_11_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(database: Android11Database): UserDao {
        return database.userDao()
    }
}