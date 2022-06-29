package com.maya.joke.entiti

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JokesItem::class], version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun ListJokesDao() : ListJokesDao
}