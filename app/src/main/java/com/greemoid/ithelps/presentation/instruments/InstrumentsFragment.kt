package com.greemoid.ithelps.presentation.instruments

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentInstrumentsBinding
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class InstrumentsFragment :
    BaseFragment<DailyTasksViewModel, FragmentInstrumentsBinding>(FragmentInstrumentsBinding::inflate) {

    override val visibility: Int = View.VISIBLE
    override val viewModel: DailyTasksViewModel by sharedViewModel()

    override fun init() {
        binding.btnMoodTracker.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_choiceMoodFragment)
        }

        binding.btnDiary.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_diaryFragment)
        }

        binding.btnMeditation.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_meditationFragment)
        }

        binding.btnAnswers.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_questionsAndAnswersFragment)
        }

        binding.btnControl.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_conditionControlFragment)
        }

        binding.btnAffirmations.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_affirmationsFragment)
        }

        binding.btnQuotes.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_quotesFragment)
        }

        binding.btnArticles.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://t.me/architectureofmind")
            startActivity(intent)
        }

        binding.btnBreathing.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_choiceOfExerciseFragment)
        }
    }
}