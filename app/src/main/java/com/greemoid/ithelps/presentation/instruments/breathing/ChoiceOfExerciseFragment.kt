package com.greemoid.ithelps.presentation.instruments.breathing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentChoiceOfExerciseBinding
import com.greemoid.ithelps.domain.models.breathing.BreathingType
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoiceOfExerciseFragment : BaseFragment<EmptyViewModel, FragmentChoiceOfExerciseBinding>(
    FragmentChoiceOfExerciseBinding::inflate) {

    override val viewModel: EmptyViewModel by viewModels()
    override val visibility: Int = View.GONE
    override fun init() {
        with(binding) {
            btnBack.navigate(R.id.action_choiceOfExerciseFragment_to_instrumentsFragment)

            btnRefresh.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.refresh,
                    breathingName = "Перезагрузка",
                    breath = 3,
                    firstDelay = 2,
                    exhalation = 4,
                    secondDelay = 1
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }

            btnDeepBreathing.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.deep,
                    breathingName = "Глибоке дихання",
                    breath = 4,
                    firstDelay = 4,
                    exhalation = 4,
                    secondDelay = 4
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }

            btnWakingUp.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.alarm,
                    breathingName = "Пробудження",
                    breath = 2,
                    firstDelay = 1,
                    exhalation = 2,
                    secondDelay = 1
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }

            btnRelax.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.relax,
                    breathingName = "Спокій",
                    breath = 6,
                    firstDelay = 7,
                    exhalation = 8,
                    secondDelay = 1
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }

            btnPain.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.pain,
                    breathingName = "Облегчення болю",
                    breath = 4,
                    firstDelay = 4,
                    exhalation = 6,
                    secondDelay = 1
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }

            btnSOS.setOnClickListener {
                val breathingType = BreathingType(
                    drawableId = R.drawable.sos,
                    breathingName = "SOS",
                    breath = 3,
                    exhalation = 3,
                    secondDelay = 1
                )
                val bundle = Bundle()
                bundle.putSerializable("breathingType", breathingType)
                findNavController()
                    .navigate(R.id.action_choiceOfExerciseFragment_to_breathingFragment, bundle)
            }
        }
    }
}