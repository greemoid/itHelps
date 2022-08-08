package com.greemoid.ithelps.presentation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentTaskItemBinding


class TaskItemFragment : Fragment() {

    private lateinit var binding: FragmentTaskItemBinding
    private val args: TaskItemFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTaskItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task = args.task
        with(binding) {
            tvTitle.text = task.title
            tvDescription.text = task.description
            tvChapter.text = task.taskType
            tvDateOfTask.text = task.date
        }
        binding.btnClose.setOnClickListener {
            findNavController().navigate(R.id.action_taskItemFragment_to_todoListTasksFragment)
        }
    }

}