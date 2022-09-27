package com.greemoid.ithelps.presentation.insights.mood

import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.MoodItemLayoutBinding
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.models.mood.MoodNames
import javax.inject.Inject

class InsightsMoodViewHolder @Inject constructor(val binding: MoodItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(mood: Mood) {
        with(binding) {
            val drawable: Int = when (mood.moodType) {
                MoodNames.JOY.toString() -> R.drawable.joy
                MoodNames.LOVE.toString() -> R.drawable.love
                MoodNames.CARELESSNESS.toString() -> R.drawable.carelessness
                MoodNames.INSPIRATION.toString() -> R.drawable.inspiration
                MoodNames.ANGER.toString() -> R.drawable.anger
                MoodNames.IRRITATION.toString() -> R.drawable.irritation
                MoodNames.DISCONTENT.toString() -> R.drawable.discontent
                MoodNames.INSULT.toString() -> R.drawable.insult
                MoodNames.MALICE.toString() -> R.drawable.malice
                MoodNames.JEALOUSY.toString() -> R.drawable.jealousy
                MoodNames.SORROW.toString() -> R.drawable.sorrow
                MoodNames.DISAPPOINTMENT.toString() -> R.drawable.disappointed
                MoodNames.DESPAIR.toString() -> R.drawable.despair
                MoodNames.UPSET.toString() -> R.drawable.upset
                MoodNames.GRIEF.toString() -> R.drawable.grief
                MoodNames.FEAR.toString() -> R.drawable.fear
                MoodNames.CONCERN.toString() -> R.drawable.concern
                MoodNames.ANXIETY.toString() -> R.drawable.anxiety
                MoodNames.PANIC.toString() -> R.drawable.panic
                MoodNames.FAULT.toString() -> R.drawable.fault
                else -> R.drawable.anger
            }
            ivMood.setImageResource(drawable)
            tvMoodItem.text = mood.moodDescription
            tvMoodTitle.text = mood.moodType
        }
    }
}