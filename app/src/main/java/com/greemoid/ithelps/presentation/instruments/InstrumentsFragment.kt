package com.greemoid.ithelps.presentation.instruments

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.fragment.app.viewModels
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentInstrumentsBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstrumentsFragment :
    BaseFragment<EmptyViewModel, FragmentInstrumentsBinding>(FragmentInstrumentsBinding::inflate) {

    override val visibility: Int = View.VISIBLE
    override val viewModel: EmptyViewModel by viewModels()

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