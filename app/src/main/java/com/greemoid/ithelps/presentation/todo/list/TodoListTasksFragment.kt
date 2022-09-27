package com.greemoid.ithelps.presentation.todo.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentTodoListTasksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListTasksFragment :
    BaseFragment<TodoListTasksViewModel, FragmentTodoListTasksBinding>(FragmentTodoListTasksBinding::inflate) {

    override val viewModel: TodoListTasksViewModel by viewModels()
    private lateinit var adapter: TodoTasksAdapter
    override val visibility: Int = View.GONE


    override fun init() {
        setupRecyclerView()
        val args: TodoListTasksFragmentArgs by navArgs()
        val type: String = args.type
        binding.btnClose.setOnClickListener {
            findNavController()
                .navigate(R.id.action_todoListTasksFragment_to_todoFragment)
        }
        viewModel.getByType(type).observe(viewLifecycleOwner) { list ->
            adapter.differ.submitList(list.asReversed())
        }

        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable("task", it)
            findNavController()
                .navigate(R.id.action_todoListTasksFragment_to_taskItemFragment,
                    bundle)
        }
    }

    private fun setupRecyclerView() {
        adapter = TodoTasksAdapter(viewModel)
        val recyclerView = binding.recyclerviewListOfTasks
        recyclerView.adapter = adapter
    }

}