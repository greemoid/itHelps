package com.greemoid.ithelps.presentation.dailyTasks

import android.view.View
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentDailyTaskBinding
import com.greemoid.ithelps.databinding.FragmentDailyTasksBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DailyTasksFragment :
    BaseFragment<DailyTasksViewModel, FragmentDailyTaskBinding>(FragmentDailyTaskBinding::inflate) {

    override val viewModel: DailyTasksViewModel by sharedViewModel()
    override val visibility: Int = View.VISIBLE

    override fun init() {
        viewModel.update()
        binding.tvDate.text = viewModel.day
        viewModel.meditation.observe(this) {
            binding.cbMeditation.isChecked = it
        }

        viewModel.mood.observe(this) {
            binding.cbMood.isChecked = it
        }

        viewModel.note.observe(this) {
            binding.cbDiary.isChecked = it
        }
        binding.ivAvatar.setOnClickListener {
            findNavController()
                .navigate(R.id.action_dailyTasksFragment_to_accountFragment)
        }
        binding.diaryLayout.setOnClickListener {
            findNavController()
                .navigate(R.id.action_dailyTasksFragment_to_diaryFragment)
        }
        binding.moodLayout.setOnClickListener {
            findNavController()
                .navigate(R.id.action_dailyTasksFragment_to_choiceMoodFragment)
        }
        binding.meditationLayout.setOnClickListener {
            findNavController()
                .navigate(R.id.action_dailyTasksFragment_to_meditationFragment)
        }
    }
}

