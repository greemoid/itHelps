package com.greemoid.ithelps.presentation.account

import android.view.View
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentAccountBinding
import com.greemoid.ithelps.presentation.core.EmptyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class AccountFragment :
    BaseFragment<EmptyViewModel, FragmentAccountBinding>(FragmentAccountBinding::inflate) {

    override val viewModel: EmptyViewModel by sharedViewModel()

    override fun init() {
    }

    override val visibility: Int = View.GONE

}