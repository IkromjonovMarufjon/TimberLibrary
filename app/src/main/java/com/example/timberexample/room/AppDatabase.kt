package com.example.timberexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 *  Created by Ikromjonov Ma'rufjon
 *  data = 4/26/2020 , time = 12:51
 */

@Database(entities = [LogEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun LogDao(): LogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,
                        "TimberExample").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}