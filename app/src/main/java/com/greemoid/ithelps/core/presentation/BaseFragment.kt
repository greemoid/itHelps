package com.greemoid.ithelps.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.greemoid.ithelps.presentation.MainActivity

abstract class BaseFragment<VM : ViewModel, VB : ViewBinding>(private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
    Fragment() {

    protected abstract val viewModel: VM
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflateMethod.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    abstract val visibility: Int

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).setBottomNavigationVisibility(visibility)
    }
    abstract fun init()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}