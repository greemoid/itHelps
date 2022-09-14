package com.greemoid.ithelps.presentation.todo.list

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.databinding.TaskItemLayoutBinding
import com.greemoid.ithelps.domain.models.todo.TaskTypes


class TodoTasksAdapter(val viewModel: TodoListTasksViewModel) :
    RecyclerView.Adapter<TodoTasksAdapter.TodoTasksViewHolder>() {

    //todo сюда приходить модель з бд а не з презентейшн або домейн хоча б

    inner class TodoTasksViewHolder(
        private val binding: TaskItemLayoutBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskDB) {
            with(binding) {
                tvTitleTask.text = task.title
                tvItemDate.text = task.date
            }
            itemView.setOnClickListener {
                onItemClickListener?.let { it(task) }
            }
            if (task.isDone) {
                binding.checkboxTask.isChecked = true
                binding.tvTitleTask.paintFlags =
                    binding.tvTitleTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
            binding.checkboxTask.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {    // Устанавливаем флаг зачёркивания
                    binding.tvTitleTask.paintFlags =
                        binding.tvTitleTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    val taskDB = TaskDB(
                        id = task.id,
                        title = task.title,
                        description = task.description,
                        taskType = TaskTypes.HISTORY.chapter,
                        date = task.date,
                        isDone = true
                    )
                    viewModel.update(taskDB)
                } else {    // Убираем флаг зачёркивания
                    binding.tvTitleTask.paintFlags =
                        binding.tvTitleTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    val taskDB = TaskDB(
                        id = task.id,
                        title = task.title,
                        description = task.description,
                        taskType = TaskTypes.HISTORY.chapter,
                        date = task.date,
                        isDone = false
                    )
                    viewModel.update(taskDB)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTasksViewHolder {
        val binding = TaskItemLayoutBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoTasksViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TodoTasksViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<TaskDB>() {
        override fun areItemsTheSame(oldItem: TaskDB, newItem: TaskDB): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TaskDB, newItem: TaskDB): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    fun setOnItemClickListener(listener: (TaskDB) -> Unit) {
        onItemClickListener = listener
    }

    private var onItemClickListener: ((TaskDB) -> Unit)? = null

}