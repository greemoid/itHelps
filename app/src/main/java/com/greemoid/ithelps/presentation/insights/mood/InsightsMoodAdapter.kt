package com.greemoid.ithelps.presentation.insights.mood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.InsightsMoodItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.models.mood.Mood

class InsightsMoodAdapter(private val limit: Int) : RecyclerView.Adapter<InsightsMoodViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsightsMoodViewHolder {
        val binding = InsightsMoodItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return InsightsMoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsightsMoodViewHolder, position: Int) =
        holder.bind(differ.currentList[position])

    override fun getItemCount(): Int {
        return if (differ.currentList.size > limit && limit != 0) {
            limit
        } else {
            differ.currentList.size
        }
    }


    private val differCallback = object : DiffUtil.ItemCallback<Mood>() {
        override fun areItemsTheSame(oldItem: Mood, newItem: Mood): Boolean {
            return oldItem.moodDescription == newItem.moodDescription
        }

        override fun areContentsTheSame(oldItem: Mood, newItem: Mood): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}