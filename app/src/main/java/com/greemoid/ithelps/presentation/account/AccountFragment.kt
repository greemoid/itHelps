package com.greemoid.ithelps.presentation.account

import android.view.View
import androidx.fragment.app.viewModels
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentAccountBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment :
    BaseFragment<EmptyViewModel, FragmentAccountBinding>(FragmentAccountBinding::inflate) {

    override val viewModel: EmptyViewModel by viewModels()

    override fun init() {
    }

    override val visibility: Int = View.GONE

}