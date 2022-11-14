package com.greemoid.ithelps.presentation.insights

import android.view.View
import androidx.fragment.app.viewModels
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentInsightsBinding
import com.greemoid.ithelps.presentation.insights.diary.InsightsDiaryAdapter
import com.greemoid.ithelps.presentation.insights.mood.InsightsMoodAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsightsFragment :
    BaseFragment<InsightsViewModel, FragmentInsightsBinding>(FragmentInsightsBinding::inflate) {

    override val viewModel: InsightsViewModel by viewModels()
    override val visibility: Int = View.VISIBLE

    override fun init() {
        binding.btnGoToNotes.navigate(R.id.action_insightsFragment_to_diaryListFragment)
        binding.btnGoToMood.navigate(R.id.action_insightsFragment_to_moodListFragment)
    }
}