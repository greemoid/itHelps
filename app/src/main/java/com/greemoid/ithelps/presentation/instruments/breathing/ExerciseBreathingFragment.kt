package com.greemoid.ithelps.presentation.instruments.breathing


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentExerciseBreathingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
        viewModel.startTotalTimer(
            breathingTime.totalTime,
            breathingTime.breath,
            breathingTime.firstDelay,
            breathingTime.exhalation,
            breathingTime.secondDelay)
        viewModel.startBreathTimer(
            breathingTime.breath,
            breathingTime.firstDelay,
            breathingTime.exhalation,
            breathingTime.secondDelay)
        val zoomIn = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in)
        val zoomOut = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_out)
        viewModel.millisBreath.observe(viewLifecycleOwner) {
            binding.tvTime.text = it
        }
        viewModel.breath.observe(viewLifecycleOwner) {
            binding.tvBreath.text = it
        }
        viewModel.breathTimeForAnim.observe(viewLifecycleOwner) {
            zoomIn.duration = it
            zoomOut.duration = it
        }
        viewModel.totalTime.observe(viewLifecycleOwner) {
            binding.tvTotalTime.text = it
        }
        binding.btnBack.setOnClickListener {
            viewModel.cancelTimer()
            findNavController()
                .navigate(R.id.action_exerciseBreathingFragment_to_choiceOfExerciseFragment)
        }

        viewModel.isBreathTimer.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        binding.ivTest.startAnimation(zoomIn)
                        zoomIn.fillAfter = true
                    }
                }
            }
        }
        viewModel.isExhalationTimer.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        binding.ivTest.startAnimation(zoomOut)
                        zoomIn.fillAfter = true
                    }
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.cancelTimer()
    }

}