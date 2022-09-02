package com.greemoid.ithelps.presentation.todo.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentTodoListTasksBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TodoListTasksFragment :
    BaseFragment<TodoListTasksViewModel, FragmentTodoListTasksBinding>(FragmentTodoListTasksBinding::inflate) {

    private val args: TodoListTasksFragmentArgs by navArgs()
    override val viewModel: TodoListTasksViewModel by sharedViewModel()
    private val adapter: TodoTasksAdapter = TodoTasksAdapter(viewModel)
    override val visibility: Int = View.GONE


    override fun init() {
        setupRecyclerView()
        val type: String = args.type
        binding.btnClose.setOnClickListener {
            findNavController()
                .navigate(R.id.action_todoListTasksFragment_to_todoFragment)
        }
        viewModel.getByType(type).observe(viewLifecycleOwner) { list ->
            adapter.submitList(list.asReversed())
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
        val recyclerView = binding.recyclerviewListOfTasks
        recyclerView.adapter = adapter
    }

}