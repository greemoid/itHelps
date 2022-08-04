package com.greemoid.ithelps.presentation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.FragmentTodoListTasksBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TodoListTasksFragment : Fragment() {

    private lateinit var binding: FragmentTodoListTasksBinding
    private lateinit var adapter: TodoTasksAdapter
    private lateinit var recyclerView: RecyclerView
    private val args: TodoListTasksFragmentArgs by navArgs()
    private val viewModel: TodoListTasksViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTodoListTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val type: String = args.type

        viewModel.getByType(type).observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    private fun setupRecyclerView() {
        adapter = TodoTasksAdapter()
        recyclerView = binding.recyclerviewListOfTasks
        recyclerView.adapter = adapter
    }

}