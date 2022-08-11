package com.greemoid.ithelps.presentation.instruments.breathing


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentExerciseBreathingBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ExerciseBreathingFragment : Fragment() {

    private lateinit var binding: FragmentExerciseBreathingBinding
    private val args: ExerciseBreathingFragmentArgs by navArgs()
    private val viewModel: ExerciseBreathingViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentExerciseBreathingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val breathingTime = args.breathingTime
        viewModel.startTotalTimer(breathingTime.totalTime, breathingTime.breath, breathingTime.firstDelay, breathingTime.exhalation, breathingTime.secondDelay)
        viewModel.startBreathTimer(breathingTime.breath, breathingTime.firstDelay, breathingTime.exhalation, breathingTime.secondDelay)
        viewModel.millisBreath.observe(viewLifecycleOwner) {
            binding.tvTime.text = it
        }
        viewModel.breath.observe(viewLifecycleOwner) {
            binding.tvBreath.text = it
        }
        viewModel.totalTime.observe(viewLifecycleOwner) {
            binding.tvTotalTime.text = it
        }
        binding.btnBack.setOnClickListener {
            viewModel.cancelTimer()
            findNavController().navigate(R.id.action_exerciseBreathingFragment_to_choiceOfExerciseFragment)
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.cancelTimer()
    }

}