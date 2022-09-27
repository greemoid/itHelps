package com.greemoid.ithelps.presentation.diary

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentDiaryBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryFragment :
    BaseFragment<DiaryViewModel, FragmentDiaryBinding>(FragmentDiaryBinding::inflate) {

    override val viewModel: DiaryViewModel by viewModels()
    override val visibility: Int = View.GONE

    override fun init() {
        binding.etAnswer.requestFocus()

        binding.tvToday.text = viewModel.currentDay

        binding.btnSave.setOnClickListener {

            if (binding.etAnswer.text.isNotEmpty()) {
                val description = binding.etAnswer.text.toString()
                val diaryNote = DiaryNote(
                    description = description,
                    date = viewModel.fullyDate
                )
                viewModel.save(diaryNote)
                binding.etAnswer.text = null
                findNavController()
                    .navigate(R.id.action_diaryFragment_to_dailyTasksFragment)
            } else {
                Snackbar
                    .make(
                        binding.root,
                        "Please, input your text",
                        Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
        binding.btnClose.setOnClickListener {
            findNavController()
                .navigate(R.id.action_diaryFragment_to_dailyTasksFragment)
        }
    }

}