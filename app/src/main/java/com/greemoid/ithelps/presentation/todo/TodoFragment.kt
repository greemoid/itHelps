package com.greemoid.ithelps.presentation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentTodoBinding
import com.greemoid.ithelps.domain.models.todo.TaskTypes


class TodoFragment : Fragment() {


    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.action_todoFragment_to_todoAddFragment)
        }
        binding.linLayoutFirst.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.IMPORTANTANDURGENT.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSecond.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.IMPORTANT.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutThird.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.URGENT.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutFourth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.NOTIMPORTANTANDNOTURGENT.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutFifth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.DAILY.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSixth.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.GROCERIES.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

        binding.linLayoutSeventh.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("type", TaskTypes.HISTORY.chapter)
            findNavController().navigate(R.id.action_todoFragment_to_todoListTasksFragment, bundle)
        }

    }


}