package com.devbuildrun.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.devbuildrun.todoapp.databinding.ActivityMainBinding
import com.devbuildrun.todoapp.navigation.TodoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
//        binding.bottomNavigation.selectedItemId =
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_todoitems -> {
                var todoFragment = TodoFragment()
                supportFragmentManager.beginTransaction().replace(R.id.animateToEnd, todoFragment).commit()
                return false
            }
        }
        return false
    }
}