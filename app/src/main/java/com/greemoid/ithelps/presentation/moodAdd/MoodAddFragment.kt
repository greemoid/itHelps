package com.greemoid.ithelps.presentation.moodAdd

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentMoodAddBinding
import com.greemoid.ithelps.domain.models.mood.Mood
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MoodAddFragment :
    BaseFragment<MoodAddViewModel, FragmentMoodAddBinding>(FragmentMoodAddBinding::inflate) {

    private val args: MoodAddFragmentArgs by navArgs()
    override val viewModel: MoodAddViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    override fun init() {
        val moodArgs = args.moodType
        binding.tvMood.text = moodArgs.moodName
        binding.ivMood.setImageResource(moodArgs.drawableId)
        binding.btnSave.setOnClickListener {
            if (binding.editTextTextOfDiary.text.isNotEmpty()) {
                val description = binding.editTextTextOfDiary.text.toString()
                val mood = Mood(
                    moodType = moodArgs.typeEnum.toString(),
                    moodDescription = description,
                    date = viewModel.fullyDate
                )
                viewModel.save(mood)
                binding.editTextTextOfDiary.text = null
                findNavController()
                    .navigate(R.id.action_moodAddFragment_to_dailyTasksFragment)
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
                .navigate(R.id.action_moodAddFragment_to_dailyTasksFragment)
        }
    }
}