package com.example.timberexample.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  Created by Ikromjonov Ma'rufjon
 *  data = 4/26/2020 , time = 12:46
 */

@Entity
class LogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tag: String,
    val message : String
)

/*
@Entity
data class LanguageInfoData(
    @PrimaryKey val id : Int,
    val name : String,
    val voicesCount : Int,
    val exercisesCount : Int,
    val uploadedCount : Int,
    val version : String,
    val ImageUrl : String,
    val money : String,
    val infoPackage : String
)
* */