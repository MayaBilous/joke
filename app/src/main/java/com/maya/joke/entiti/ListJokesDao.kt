package com.maya.joke.entiti

import androidx.room.*

@Dao
interface ListJokesDao {

    @Query("SELECT * FROM jokesItem ")
    fun getAll(): List<JokesItem>

    @Delete()
    fun delete(item: JokesItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: JokesItem)
}