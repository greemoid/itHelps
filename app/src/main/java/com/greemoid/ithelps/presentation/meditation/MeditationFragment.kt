package com.greemoid.ithelps.presentation.meditation

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.core.presentation.BaseFragment
import com.greemoid.ithelps.databinding.FragmentMeditationBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MeditationFragment :
    BaseFragment<MeditationViewModel, FragmentMeditationBinding>(FragmentMeditationBinding::inflate) {

    override val viewModel: MeditationViewModel by sharedViewModel()
    override val visibility: Int = View.GONE

    //todo move it to another file and make init smaller
    override fun init() {
        var etTime: String = ""
        var time: Long = 0
        binding.btnStart.visibility = View.VISIBLE
        binding.btnStop.visibility = View.INVISIBLE
        binding.btnSetTime.setOnClickListener {
            etTime = binding.etTimer.text.toString()
            binding.etTimer.visibility = View.GONE
            binding.btnSetTime.visibility = View.GONE
            binding.tvTimer.visibility = View.VISIBLE
            binding.tvTimer.text = "$etTime:00"
            binding.etTimer.text = null
            hideKeyboard()
        }

        binding.btnStart.setOnClickListener {
            time = etTime.toLong() * 60000
            viewModel.startTimer(time)
            binding.btnStart.visibility = View.INVISIBLE
            binding.btnStop.visibility = View.VISIBLE
        }

        binding.btnStop.setOnClickListener {
            viewModel.cancelTimer()
            etTime = ""
            time = 0
            binding.etTimer.visibility = View.VISIBLE
            binding.btnSetTime.visibility = View.VISIBLE
            binding.tvTimer.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.btnStop.visibility = View.INVISIBLE
        }

        binding.btnBack.setOnClickListener {
            viewModel.cancelTimer()
            findNavController()
                .navigate(R.id.action_meditationFragment_to_dailyTasksFragment)
        }

        viewModel.millis.observe(viewLifecycleOwner) {
            binding.tvTimer.text = it
        }
    }

    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager
            .hideSoftInputFromWindow(view.windowToken, 0)
    }
}