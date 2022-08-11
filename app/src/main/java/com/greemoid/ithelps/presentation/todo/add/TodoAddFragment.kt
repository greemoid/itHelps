package com.greemoid.ithelps.presentation.todo.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentTodoAddBinding
import com.greemoid.ithelps.domain.models.todo.Task
import com.greemoid.ithelps.domain.models.todo.TaskTypes
import com.greemoid.ithelps.presentation.core.Date
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TodoAddFragment : Fragment() {

    private lateinit var binding: FragmentTodoAddBinding
    private val viewModel: TodoAddViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTodoAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            findNavController().navigate(R.id.action_todoAddFragment_to_todoFragment)
        }

        binding.btnCustomDate.setOnClickListener {
            binding.btnCustomDate.visibility = View.GONE
            binding.datePicker.visibility = View.VISIBLE
            binding.btnSaveDate.visibility = View.VISIBLE
        }

        binding.btnSaveDate.setOnClickListener {
            val day = binding.datePicker.dayOfMonth
            val month = binding.datePicker.month
            val year = binding.datePicker.year
            binding.rbCustom.text = "${day}.${month}.${year}"
            binding.btnCustomDate.visibility = View.VISIBLE
            binding.datePicker.visibility = View.GONE
            binding.btnSaveDate.visibility = View.GONE
        }

        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty()) {
                val title = binding.etTitle.text.toString()
                val description = binding.etDescription.text.toString()
                val taskType = when (binding.spinnerChapters.selectedItemId.toInt()) {
                    0 -> TaskTypes.IMPORTANTANDURGENT.chapter
                    1 -> TaskTypes.IMPORTANT.chapter
                    2 -> TaskTypes.URGENT.chapter
                    3 -> TaskTypes.NOTIMPORTANTANDNOTURGENT.chapter
                    4 -> TaskTypes.DAILY.chapter
                    5 -> TaskTypes.GROCERIES.chapter
                    6 -> TaskTypes.HISTORY.chapter
                    else -> ""
                }
                val dateClass = Date()
                val date = when (binding.radioGroupDates.checkedRadioButtonId) {
                    binding.rbToday.id -> dateClass.getCurrentFullDate()
                    binding.rbTomorrow.id -> dateClass.getTomorrow()
                    binding.rbCustom.id -> binding.rbCustom.text.toString()
                    else -> ""
                }
                val isDone = false
                val task = Task(
                    title,
                    description,
                    taskType,
                    date,
                    isDone
                )
                viewModel.saveTask(task)
                findNavController().navigate(R.id.action_todoAddFragment_to_todoFragment)
            } else {
                Snackbar
                    .make(
                        binding.root,
                        "Please, input your title",
                        Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }


}