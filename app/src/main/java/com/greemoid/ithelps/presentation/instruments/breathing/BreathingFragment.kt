package com.greemoid.ithelps.presentation.instruments.breathing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.databinding.FragmentBreathingBinding


class BreathingFragment : Fragment() {

    //private lateinit var binding: FragmentBreathingBinding
    private var _binding: FragmentBreathingBinding? = null
    private val binding get() = _binding!!
    private val args: BreathingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBreathingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val breathingType = args.breathingType
        binding.ivBreathingType.setImageResource(breathingType.drawableId)
        binding.tvBreathingName.text = breathingType.breathingName
        binding.tvBreathTime.text = breathingType.breath.toString()
        binding.tvFirstDelayTime.text = breathingType.firstDelay.toString()
        binding.tvExhalationTime.text = breathingType.exhalation.toString()
        binding.tvSecondDelayTime.text = breathingType.secondDelay.toString()

        val timeOfOneItteration =
            (breathingType.breath + breathingType.firstDelay + breathingType.exhalation + breathingType.secondDelay) * 4


        val minutes = timeOfOneItteration / 60
        val seconds = timeOfOneItteration % 60
        binding.tvTotalTime.text = "$minutes хв $seconds сек"
        binding.tvCountOfSets.text = "1 set"

        binding.seekBarCountOfSets.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val totalTime = timeOfOneItteration * seek.progress
                val minutesSeek = totalTime / 60
                val secondsSeek = totalTime % 60
                binding.tvTotalTime.text = "$minutesSeek хв $secondsSeek сек"
                binding.tvCountOfSets.text = "${seek.progress} set(s)"
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}