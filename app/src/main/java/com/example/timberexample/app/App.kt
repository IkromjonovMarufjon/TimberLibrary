package com.example.timberexample.app

import android.app.Application
import androidx.room.Room
import com.example.timberexample.BuildConfig
import com.example.timberexample.room.AppDatabase
import com.example.timberexample.room.RoomLogsTree
import timber.log.Timber

/**
 *  Created by Ikromjonov Ma'rufjon
 *  data = 4/25/2020 , time = 20:35
 */

class App : Application() {

    companion object {
        var database : AppDatabase? = null
    }
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, AppDatabase::class.java, "TimberLogs")
                .allowMainThreadQueries()
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(RoomLogsTree(this))
        }

    }
}
