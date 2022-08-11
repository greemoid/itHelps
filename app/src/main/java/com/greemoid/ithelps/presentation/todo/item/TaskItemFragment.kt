package com.greemoid.ithelps.presentation.todo.item

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentTaskItemBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TaskItemFragment : Fragment() {

    private lateinit var binding: FragmentTaskItemBinding
    private val args: TaskItemFragmentArgs by navArgs()
    private val viewModel: TaskItemViewModel by sharedViewModel()


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