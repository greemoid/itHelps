package com.greemoid.ithelps.presentation.insights.diary

import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.DiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import javax.inject.Inject

class InsightsDiaryViewHolder @Inject constructor(val binding: DiaryItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(note: DiaryNote) {
        with(binding) {
            //todo format date like "Sep\n12"
            //tvDateItem.text = note.date
            tvDateItem.text = "Sep\n12"
            tvDiaryTextItem.text = note.description
        }
    }
}