package com.greemoid.ithelps.presentation.account

import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentAccountBinding
import com.greemoid.ithelps.presentation.dailyTasks.DailyTasksViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class AccountFragment :
    BaseFragment<DailyTasksViewModel, FragmentAccountBinding>(FragmentAccountBinding::inflate) {

    override val viewModel: DailyTasksViewModel by sharedViewModel()

    override fun init() {
        binding.textView.text = viewModel.day
    }

    override val visibility: Int = View.GONE

}