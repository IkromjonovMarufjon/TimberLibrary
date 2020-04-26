package com.example.timberexample.room

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.timberexample.app.App
import timber.log.Timber
import java.util.logging.Logger

/**
 *  Created by Ikromjonov Ma'rufjon
 *  data = 4/26/2020 , time = 12:58
 */

class RoomLogsTree(context: Context) : Timber.DebugTree() {
    private val database = App.database

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, tag, message, t)

        val d = tag?.let { LogEntity(0, it,message) }
        d?.let { database!!.LogDao().insert(it) }
    }
}
