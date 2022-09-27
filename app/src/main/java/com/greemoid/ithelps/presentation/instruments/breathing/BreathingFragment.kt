package com.greemoid.ithelps.presentation.instruments.breathing

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentBreathingBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreathingFragment :
    BaseFragment<EmptyViewModel, FragmentBreathingBinding>(FragmentBreathingBinding::inflate) {

    //todo clean up init(); move it to customview

    private val args: BreathingFragmentArgs by navArgs()
    override val viewModel: EmptyViewModel by viewModels()
    override val visibility: Int = View.GONE

    override fun init() {
        val breathingType = args.breathingType
        val breath = breathingType.breath
        val firstDelay = breathingType.firstDelay
        val exhalation = breathingType.exhalation
        val secondDelay = breathingType.secondDelay
        binding.ivBreathingType.setImageResource(breathingType.drawableId)
        binding.tvBreathingName.text = breathingType.breathingName
        binding.tvBreathTime.text = breath.toString()
        binding.tvFirstDelayTime.text = firstDelay.toString()
        binding.tvExhalationTime.text = exhalation.toString()
        binding.tvSecondDelayTime.text = secondDelay.toString()

        val timeOfOneIteration =
            (breathingType.breath
                    + breathingType.firstDelay
                    + breathingType.exhalation
                    + breathingType.secondDelay) * 4

        val minutes = timeOfOneIteration / 60
        val seconds = timeOfOneIteration % 60
        binding.tvTotalTime.text = "$minutes хв $seconds сек"
        binding.tvCountOfSets.text = "1 set"

        var totalTimeWithSeek = 0

        binding.seekBarCountOfSets.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                totalTimeWithSeek = timeOfOneIteration * seek.progress
                val minutesSeek = totalTimeWithSeek / 60
                val secondsSeek = totalTimeWithSeek % 60
                binding.tvTotalTime.text = "$minutesSeek хв $secondsSeek сек"
                binding.tvCountOfSets.text = "${seek.progress} set(s)"
            }
        })

        binding.btnStartExercise.setOnClickListener {
            val breathingTime = BreathingTime(
                totalTime = totalTimeWithSeek,
                breath = breath,
                firstDelay = firstDelay,
                exhalation = exhalation,
                secondDelay = secondDelay
            )
            val bundle = Bundle()
            bundle.putSerializable("breathingTime", breathingTime)
            findNavController()
                .navigate(R.id.action_breathingFragment_to_exerciseBreathingFragment,
                    bundle)
        }
    }
}