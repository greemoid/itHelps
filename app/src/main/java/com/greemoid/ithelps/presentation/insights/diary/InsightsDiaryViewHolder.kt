package com.greemoid.ithelps.presentation.insights.diary

import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.InsightsDiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class InsightsDiaryViewHolder(val binding: InsightsDiaryItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(note: DiaryNote) {
        with(binding) {
            tvDateItem.text = note.date
            tvDiaryTextItem.text = note.description
        }
    }
}