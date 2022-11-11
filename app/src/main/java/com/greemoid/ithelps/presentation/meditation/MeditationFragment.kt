package com.greemoid.ithelps.presentation.meditation

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentMeditationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeditationFragment :
    BaseFragment<MeditationViewModel, FragmentMeditationBinding>(
        FragmentMeditationBinding::inflate) {

    override val viewModel: MeditationViewModel by viewModels()
    override val visibility: Int = View.GONE

    //todo move it to another file and make init smaller
    override fun init() {
        var etTime = 5
        var time: Long
        binding.btnStart.visibility = View.VISIBLE
        binding.btnStop.visibility = View.INVISIBLE
        binding.timePicker.minValue = 0
        binding.timePicker.maxValue = 60
        binding.timePicker.value = 5


        binding.timePicker.setOnValueChangedListener { _, _, newVal ->
            etTime = newVal
        }
        binding.btnStart.setOnClickListener {

            time = etTime.toLong() * 60000
            viewModel.startTimer(time)
            binding.timePicker.visibility = View.INVISIBLE
            binding.btnStart.visibility = View.INVISIBLE
            binding.btnStop.visibility = View.VISIBLE
            binding.tvTimer.visibility = View.VISIBLE
        }

        binding.btnStop.setOnClickListener {
            viewModel.cancelTimer()
            etTime = 5
            time = 0
            binding.timePicker.visibility = View.VISIBLE
            binding.tvTimer.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.btnStop.visibility = View.INVISIBLE
        }

        binding.btnBack.setOnClickListener {
            viewModel.cancelTimer()
            findNavController()
                .navigate(R.id.action_meditationFragment_to_dailyTasksFragment)
        }

        viewModel.millis.observe(viewLifecycleOwner) {
            binding.tvTimer.text = it
        }
    }
}