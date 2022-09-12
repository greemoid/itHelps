package com.greemoid.ithelps.presentation.instruments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
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
        with(binding) {
            btnMoodTracker.navigate(R.id.action_instrumentsFragment_to_choiceMoodFragment)
            btnDiary.navigate(R.id.action_instrumentsFragment_to_diaryFragment)
            btnMeditation.navigate(R.id.action_instrumentsFragment_to_meditationFragment)
            btnAnswers.navigate(R.id.action_instrumentsFragment_to_questionsAndAnswersFragment)
            btnControl.navigate(R.id.action_instrumentsFragment_to_conditionControlFragment)
            btnAffirmations.navigate(R.id.action_instrumentsFragment_to_affirmationsFragment)
            btnQuotes.navigate(R.id.action_instrumentsFragment_to_quotesFragment)
            btnBreathing.navigate(R.id.action_instrumentsFragment_to_choiceOfExerciseFragment)
            btnArticles.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://t.me/aom_ua")
                startActivity(intent)
            }
        }
    }
}