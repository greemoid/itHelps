package com.greemoid.ithelps.presentation.insights.mood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.InsightsMoodItemLayoutBinding
import com.greemoid.ithelps.domain.models.mood.Mood
import com.greemoid.ithelps.domain.models.mood.MoodNames

class InsightsMoodAdapter(private val limit: Int) : RecyclerView.Adapter<InsightsMoodAdapter.InsightsMoodViewHolder>() {

    var moodsList = emptyList<Mood>()

    inner class InsightsMoodViewHolder(val binding: InsightsMoodItemLayoutBinding) :
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
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsightsMoodViewHolder {
        val binding = InsightsMoodItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return InsightsMoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsightsMoodViewHolder, position: Int) =
        holder.bind(moodsList[position])

    override fun getItemCount(): Int {
        return if (moodsList.size > limit && limit != 0) {
            limit
        } else {
            moodsList.size
        }
    }


    fun submitList(list: List<Mood>) {
        moodsList = list
        notifyDataSetChanged()
    }
}