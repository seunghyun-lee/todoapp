package com.devbuildrun.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devbuildrun.todoapp.data.Todoitem
// https://blog.yena.io/studynote/2018/09/08/Android-Kotlin-Room.html
class TodoAdapter(val context: Context, val todos: List<Todoitem>): RecyclerView.Adapter<TodoAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        fun bind(todoitem: Todoitem) {

        }
    }
}