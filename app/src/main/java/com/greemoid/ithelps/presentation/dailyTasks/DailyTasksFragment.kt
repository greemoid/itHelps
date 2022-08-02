package com.greemoid.ithelps.presentation.dailyTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentDailyTasksBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DailyTasksFragment : Fragment() {

    private lateinit var binding: FragmentDailyTasksBinding
    private val viewModel: DailyTasksViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDailyTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDate.text = viewModel.day
        binding.diaryLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dailyTasksFragment_to_diaryFragment)
        }
        binding.moodLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dailyTasksFragment_to_choiceMoodFragment)
        }
        binding.meditationLayout.setOnClickListener {
            findNavController().navigate(R.id.action_dailyTasksFragment_to_meditationFragment)
        }

    }
}

