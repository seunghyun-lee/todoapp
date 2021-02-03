package com.devbuildrun.todoapp.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devbuildrun.todoapp.R
import com.devbuildrun.todoapp.data.AppDatabase
import com.devbuildrun.todoapp.data.Todoitem
import com.devbuildrun.todoapp.databinding.FragmentTodoBinding
import kotlinx.android.synthetic.main.fragment_todo.view.*

class TodoFragment : Fragment() {

    private var appDatabase: AppDatabase? = null
    private var todoList = listOf<Todoitem>()
    private var mAdapter: TodoItemRecyclerViewAdapter? = null
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_todo, container, false)

        appDatabase = context?.let { AppDatabase.getInstance(it) }
        val r = Runnable {
            try {
                todoList = appDatabase?.todoitemDao()?.getAll()!!

            } catch (e: Exception) {
                Log.d("tag", " Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        view.mRecyclerView.adapter = TodoItemRecyclerViewAdapter(todoList)
        view.mRecyclerView.layoutManager = LinearLayoutManager(activity)


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        AppDatabase.destroyInstance()
        super.onDestroy()
    }

    inner class TodoItemRecyclerViewAdapter(val todos: List<Todoitem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            val mTitle = viewholder.findViewById<TextView>(R.id.itemName)
            mTitle.text = todos[position].toString()
        }

        override fun getItemCount(): Int {
            return todos.size
        }

    }
}