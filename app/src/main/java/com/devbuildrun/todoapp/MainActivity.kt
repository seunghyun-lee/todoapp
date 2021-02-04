package com.devbuildrun.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.devbuildrun.todoapp.databinding.ActivityMainBinding
import com.devbuildrun.todoapp.navigation.AccountFragment
import com.devbuildrun.todoapp.navigation.DetailFragment
import com.devbuildrun.todoapp.navigation.NoteFragment
import com.devbuildrun.todoapp.navigation.TodoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.selectedItemId = R.id.action_todoitems
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_calendar -> {
                var detailFragment = DetailFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, detailFragment).commit()
                return true
            }
            R.id.action_todoitems -> {
                var todoFragment = TodoFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, todoFragment).commit()
                return true
            }
            R.id.action_note -> {
                var noteFragment = NoteFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, noteFragment).commit()
                return true
            }
            R.id.action_account -> {
                var accountFragment = AccountFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, accountFragment).commit()
                return true
            }
        }
        return false
    }
}