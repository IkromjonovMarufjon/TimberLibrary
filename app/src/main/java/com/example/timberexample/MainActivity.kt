package com.example.timberexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.timberexample.app.App
import com.example.timberexample.room.LogEntity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    val database = App.database
    var pressCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("example")

        database!!.LogDao().getAllLog().observe(this,logsObserver)

        button.setOnClickListener {
            pressCount += 1
            Timber.d("pressCount $pressCount")
        }

    }
    private val logsObserver = Observer<List<LogEntity>> {
        var st = "Logs \n"
        for (i in it) st += "id = ${i.id}, tag= ${i.tag}, message= ${i.message}\n"
        text.text = st
    }
}



