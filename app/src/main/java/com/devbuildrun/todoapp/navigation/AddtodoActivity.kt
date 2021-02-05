package com.devbuildrun.todoapp.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.devbuildrun.todoapp.MainActivity
import com.devbuildrun.todoapp.R
import com.devbuildrun.todoapp.data.AppDatabase
import com.devbuildrun.todoapp.data.Todoitem
import kotlinx.android.synthetic.main.activity_addtodo.*

class AddtodoActivity : AppCompatActivity() {

    private var appDatabase: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtodo)

        appDatabase = AppDatabase.getInstance(this)

        val addRunnable = Runnable {
            val newTodoitem = Todoitem()
            newTodoitem.title = textview_title.text.toString()
            newTodoitem.detail = textview_detail.text.toString()
            appDatabase?.todoitemDao()?.insert(newTodoitem)
        }

        button_add.setOnClickListener {
            val addThread = Thread(addRunnable)
            addThread.start()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }
}