package com.greemoid.ithelps.presentation.insights.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.data.models.TaskDB
import com.greemoid.ithelps.databinding.DiaryItemLayoutBinding
import com.greemoid.ithelps.databinding.InsightsDiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class InsightsDiaryAdapter(private val limit: Int) :
    RecyclerView.Adapter<InsightsDiaryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsightsDiaryViewHolder {
        val binding = DiaryItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return InsightsDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsightsDiaryViewHolder, position: Int) =
        holder.bind(differ.currentList[position])


    override fun getItemCount(): Int {
        return if (differ.currentList.size > limit && limit != 0) {
            limit
        } else {
            differ.currentList.size
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<DiaryNote>() {
        override fun areItemsTheSame(oldItem: DiaryNote, newItem: DiaryNote): Boolean {
            return oldItem.description == newItem.description
        }

        override fun areContentsTheSame(oldItem: DiaryNote, newItem: DiaryNote): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}