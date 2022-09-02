package com.greemoid.ithelps.presentation.insights.diary

import android.view.View
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentDiaryListBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DiaryListFragment :
    BaseFragment<DiaryListViewModel, FragmentDiaryListBinding>(FragmentDiaryListBinding::inflate) {
    override val viewModel: DiaryListViewModel by sharedViewModel()
    override val visibility: Int = View.GONE
    private val adapter = InsightsDiaryAdapter(0)
    override fun init() {
        binding.btnBackToInsights.navigate(R.id.action_diaryListFragment_to_insightsFragment)
        binding.rvDiary.adapter = adapter
        viewModel.listDiary.observe(this) { list ->
            adapter.submitList(list.asReversed())
        }
    }


}