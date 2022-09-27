package com.greemoid.ithelps.presentation.instruments.affirmations

import android.view.View
import androidx.fragment.app.viewModels
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.data.source.AffirmationDataSource
import com.greemoid.ithelps.databinding.FragmentAffirmationsBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AffirmationsFragment :
    BaseFragment<EmptyViewModel, FragmentAffirmationsBinding>(FragmentAffirmationsBinding::inflate) {

    override val viewModel: EmptyViewModel by viewModels()
    override val visibility: Int = View.GONE

    override fun init() {
        val affirmationsList = AffirmationDataSource().load().shuffled()
        val viewPager = binding.viewPager
        val viewPagerAdapter = AffirmationsViewPagerAdapter(requireContext(), affirmationsList)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = 10
    }
}
