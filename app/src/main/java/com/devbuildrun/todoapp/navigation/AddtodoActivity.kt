package com.devbuildrun.todoapp.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.devbuildrun.todoapp.R
import com.devbuildrun.todoapp.data.AppDatabase
import com.devbuildrun.todoapp.data.Todoitem

class AddtodoActivity : AppCompatActivity() {

    private var appDatabase: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtodo)

        appDatabase = AppDatabase.getInstance(this)

        val addRunnable = Runnable {
            val newTodoitem = Todoitem()
//            newTodoitem.title =

        }
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }
}