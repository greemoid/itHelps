package com.greemoid.ithelps.presentation.todo

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.databinding.TaskItemLayoutBinding


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
            tvTitleTask.text = task.title
            tvItemDate.text = task.date
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(task) }
        }
        holder.binding.checkboxTask.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {    // Устанавливаем флаг зачёркивания
                holder.binding.tvTitleTask.paintFlags =
                    holder.binding.tvTitleTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {    // Убираем флаг зачёркивания
                holder.binding.tvTitleTask.paintFlags =
                    holder.binding.tvTitleTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }

    override fun getItemCount(): Int = tasksList.size

    fun submitList(tasksNewList: List<TaskDB>) {
        tasksList = tasksNewList
        notifyDataSetChanged()
    }
    fun setOnItemClickListener(listener: (TaskDB) -> Unit) {
        onItemClickListener = listener
    }

    private var onItemClickListener: ((TaskDB) -> Unit)? = null
}