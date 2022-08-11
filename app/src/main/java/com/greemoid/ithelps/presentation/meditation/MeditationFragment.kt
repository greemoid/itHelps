package com.greemoid.ithelps.presentation.meditation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentMeditationBinding
import com.greemoid.ithelps.presentation.MainActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MeditationFragment : Fragment() {

    private lateinit var binding: FragmentMeditationBinding
    private val viewModel: MeditationViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMeditationBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var etTime: String = ""
        var time: Long = 0
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
        }

        binding.btnStop.setOnClickListener {
            viewModel.cancelTimer()
            etTime = ""
            time = 0
            binding.etTimer.visibility = View.VISIBLE
            binding.btnSetTime.visibility = View.VISIBLE
            binding.tvTimer.visibility = View.GONE
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

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager
            .hideSoftInputFromWindow(view.windowToken, 0)
    }


    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }


}