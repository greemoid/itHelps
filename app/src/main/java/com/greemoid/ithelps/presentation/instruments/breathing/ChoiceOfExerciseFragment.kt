package com.greemoid.ithelps.presentation.instruments.breathing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentChoiceOfExerciseBinding
import com.greemoid.ithelps.domain.models.breathing.BreathingType
import com.greemoid.ithelps.presentation.MainActivity


class ChoiceOfExerciseFragment : Fragment() {

    private lateinit var binding: FragmentChoiceOfExerciseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChoiceOfExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController()
                .navigate(R.id.action_choiceOfExerciseFragment_to_instrumentsFragment)
        }
        binding.btnRefresh.setOnClickListener {
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

        binding.btnDeepBreathing.setOnClickListener {
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

        binding.btnWakingUp.setOnClickListener {
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

        binding.btnRelax.setOnClickListener {
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

        binding.btnPain.setOnClickListener {
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

        binding.btnSOS.setOnClickListener {
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

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }
}