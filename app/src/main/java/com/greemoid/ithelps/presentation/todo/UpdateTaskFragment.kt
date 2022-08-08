package com.greemoid.ithelps.presentation.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.databinding.FragmentUpdateTaskBinding
import com.greemoid.ithelps.domain.models.Task
import com.greemoid.ithelps.domain.models.TaskTypes
import com.greemoid.ithelps.presentation.core.Date
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class UpdateTaskFragment : Fragment() {

    private lateinit var binding: FragmentUpdateTaskBinding
    private val args: UpdateTaskFragmentArgs by navArgs()
    private val viewModel: UpdateViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentUpdateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task = args.task
        binding.etTitle.setText(task.title)
        binding.etDescription.setText(task.description)
        binding.rbCustom.text = task.date
        binding.btnSave.setOnClickListener {
            val id = task.id
            val title = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val taskType = when(binding.spinnerChapters.selectedItemId.toInt()) {
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
            val date = when(binding.radioGroupDates.checkedRadioButtonId) {
                binding.rbToday.id -> dateClass.getCurrentFullDate()
                binding.rbTomorrow.id -> dateClass.getTomorrow()
                binding.rbCustom.id -> binding.rbCustom.text.toString()
                else -> ""
            }
            val isDone = false
            val taskDB = TaskDB(
                id, title, description, taskType, date, isDone
            )
            viewModel.updateTask(taskDB)
            findNavController().navigate(R.id.action_updateTaskFragment_to_todoFragment)
        }

    }

}