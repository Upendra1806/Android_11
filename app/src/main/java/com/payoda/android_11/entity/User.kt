package com.payoda.android_11.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @field:PrimaryKey val id: String, @field:ColumnInfo(name = "name") val name: String,
    @field:ColumnInfo(name = "email") val email: String,
    @field:ColumnInfo(name = "mobile") val mobile: String,
    @field:ColumnInfo(name = "address") val address: String
)