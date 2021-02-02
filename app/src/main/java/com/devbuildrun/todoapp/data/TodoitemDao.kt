package com.devbuildrun.todoapp.data

import androidx.room.*

@Dao
interface TodoitemDao {
    @Query("SELECT * FROM Todoitem")
    fun getAll(): List<Todoitem>

    @Insert
    fun insert(todoitem: Todoitem)

    @Update
    fun update(todoitem: Todoitem)

    @Delete
    fun delete(todoitem: Todoitem)
}