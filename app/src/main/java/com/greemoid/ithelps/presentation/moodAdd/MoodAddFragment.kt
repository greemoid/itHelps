package com.greemoid.ithelps.presentation.moodAdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentMoodAddBinding
import com.greemoid.ithelps.domain.models.mood.Mood
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MoodAddFragment : Fragment() {

    private lateinit var binding: FragmentMoodAddBinding
    private val args: MoodAddFragmentArgs by navArgs()
    private val viewModel: MoodAddViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMoodAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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