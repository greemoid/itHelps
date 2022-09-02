package com.greemoid.ithelps.presentation.todo.item

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentTaskItemBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TaskItemFragment :
    BaseFragment<TaskItemViewModel, FragmentTaskItemBinding>(FragmentTaskItemBinding::inflate) {

    private val args: TaskItemFragmentArgs by navArgs()
    override val viewModel: TaskItemViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        val task = args.task
        with(binding) {
            tvTitle.text = task.title
            tvDescription.text = task.description
            tvChapter.text = task.taskType
            tvDateOfTask.text = task.date
        }
        binding.btnClose.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", task.taskType)
            findNavController()
                .navigate(R.id.action_taskItemFragment_to_todoListTasksFragment, bundle)
        }

        binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("task", task)
            findNavController()
                .navigate(R.id.action_taskItemFragment_to_updateTaskFragment, bundle)
        }

        binding.btnDelete.setOnClickListener {
            viewModel.delete(task)
            val bundle = Bundle()
            bundle.putString("type", task.taskType)
            findNavController()
                .navigate(R.id.action_taskItemFragment_to_todoListTasksFragment, bundle)
        }
    }
}