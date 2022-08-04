package com.greemoid.ithelps.presentation.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentDiaryBinding
import com.greemoid.ithelps.domain.models.DiaryNote
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DiaryFragment : Fragment() {

    private lateinit var binding: FragmentDiaryBinding
    private val viewModel: DiaryViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                findNavController().navigate(R.id.action_diaryFragment_to_dailyTasksFragment)
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
            findNavController().navigate(R.id.action_diaryFragment_to_dailyTasksFragment)
        }
    }

}