package com.greemoid.ithelps.presentation.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.databinding.TaskItemLayoutBinding
import com.greemoid.ithelps.domain.models.Task

class TodoTasksAdapter : RecyclerView.Adapter<TodoTasksAdapter.TodoTasksViewHolder>() {

    var tasksList = emptyList<TaskDB>()

    inner class TodoTasksViewHolder(val binding: TaskItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTasksViewHolder {
        val binding =
            TaskItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoTasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoTasksViewHolder, position: Int) {
        val task = tasksList[position]
        with(holder.binding) {
            checkboxTask.text = task.title
            tvItemDate.text = task.date
        }
    }

    override fun getItemCount(): Int = tasksList.size

    fun submitList(tasksNewList: List<TaskDB>) {
        tasksList = tasksNewList
        notifyDataSetChanged()
    }

}