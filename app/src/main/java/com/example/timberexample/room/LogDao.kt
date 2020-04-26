package com.example.timberexample.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 *  Created by Ikromjonov Ma'rufjon
 *  data = 4/26/2020 , time = 12:44
 */


@Dao
interface LogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: LogEntity): Long

    @Query("SELECT * FROM LogEntity")
    fun getAllLog() : LiveData<List<LogEntity>>

}