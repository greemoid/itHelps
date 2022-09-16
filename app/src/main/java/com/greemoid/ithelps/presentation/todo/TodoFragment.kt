package com.greemoid.ithelps.presentation.todo

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentTodoBinding
import com.greemoid.ithelps.domain.models.todo.TaskTypes
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TodoFragment :
    BaseFragment<EmptyViewModel, FragmentTodoBinding>(FragmentTodoBinding::inflate) {

    override val viewModel: EmptyViewModel by sharedViewModel()
    override val visibility: Int = View.VISIBLE

    override fun init() {
        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.action_todoFragment_to_todoAddFragment)
        }
        binding.linLayoutFirst.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.IMPORTANTANDURGENT.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSecond.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.IMPORTANT.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutThird.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.URGENT.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutFourth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.NOTIMPORTANTANDNOTURGENT.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutFifth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.DAILY.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSixth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.GROCERIES.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSeventh.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.HISTORY.chapter)
            findNavController()
                .navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

    }

}