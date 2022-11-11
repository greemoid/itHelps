package com.greemoid.ithelps.presentation.instruments.breathing


import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentExerciseBreathingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class ExerciseBreathingFragment :
    BaseFragment<ExerciseBreathingViewModel, FragmentExerciseBreathingBinding>(
        FragmentExerciseBreathingBinding::inflate) {

    //todo clean up init(); move it to customview

    private val args: ExerciseBreathingFragmentArgs by navArgs()
    override val visibility: Int = View.GONE
    override val viewModel: ExerciseBreathingViewModel by viewModels()

    override fun init() {
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
        binding.progressBar.max = breathingTime.totalTime
        viewModel.timeForProgress.observe(viewLifecycleOwner) {
            binding.progressBar.progress = it
        }
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
        /*viewModel.totalTime.observe(viewLifecycleOwner) {
            binding.tvTotalTime.text = it
        }*/
        binding.btnBack.setOnClickListener {
            viewModel.cancelTimer()
            findNavController()
                .navigate(R.id.action_exerciseBreathingFragment_to_choiceOfExerciseFragment)
        }

        viewModel.isBreathTimer.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        binding.ivBreathAnimation.startAnimation(zoomIn)
                        zoomIn.fillAfter = true
                    }
                }
            }
        }
        viewModel.isExhalationTimer.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {
                        binding.ivBreathAnimation.startAnimation(zoomOut)
                        zoomIn.fillAfter = true
                    }
                }
            }
        }
    }
}
