package com.greemoid.ithelps.presentation.instruments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.FragmentInstrumentsBinding
import com.greemoid.ithelps.presentation.MainActivity


class InstrumentsFragment : Fragment() {

    private lateinit var binding: FragmentInstrumentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentInstrumentsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMoodTracker.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_choiceMoodFragment)
        }

        binding.btnDiary.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_diaryFragment)
        }

        binding.btnMeditation.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_meditationFragment)
        }

        binding.btnAnswers.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_questionsAndAnswersFragment)
        }

        binding.btnControl.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_conditionControlFragment)
        }

        binding.btnAffirmations.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_affirmationsFragment)
        }

        binding.btnQuotes.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_quotesFragment)
        }

        binding.btnArticles.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://t.me/thewaytoit")
            startActivity(intent)
        }

        binding.btnBreathing.setOnClickListener {
            findNavController()
                .navigate(R.id.action_instrumentsFragment_to_choiceOfExerciseFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.VISIBLE)
        }
    }

}