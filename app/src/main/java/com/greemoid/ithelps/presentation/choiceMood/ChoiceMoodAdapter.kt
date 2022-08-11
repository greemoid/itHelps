package com.greemoid.ithelps.presentation.choiceMood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.MoodItemsLayoutBinding
import com.greemoid.ithelps.domain.models.mood.MoodType

class ChoiceMoodAdapter(
    private val dataSource: List<MoodType>,
) : RecyclerView.Adapter<ChoiceMoodAdapter.ChoiceMoodViewHolder>() {
    inner class ChoiceMoodViewHolder(val binding: MoodItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceMoodViewHolder {
        val binding =
            MoodItemsLayoutBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return ChoiceMoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChoiceMoodViewHolder, position: Int) {
        val mood = dataSource[position]
        if (mood.moodName.length > 9) {
            holder.binding.tvMoodItem.textSize = 10f
        }
        with(holder.binding) {
            tvMoodItem.text = mood.moodName
            ivMoodItem.setImageResource(mood.drawableId)
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(mood) }
        }
    }

    override fun getItemCount(): Int = dataSource.size

    fun setOnItemClickListener(listener: (MoodType) -> Unit) {
        onItemClickListener = listener
    }

}

var onItemClickListener: ((MoodType) -> Unit)? = null