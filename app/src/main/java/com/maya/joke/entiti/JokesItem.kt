package com.maya.joke.entiti

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JokesItem (
    @PrimaryKey(autoGenerate = true) val id:Long,
    val name: String
)