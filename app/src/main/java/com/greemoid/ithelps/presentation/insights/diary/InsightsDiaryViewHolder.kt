package com.greemoid.ithelps.presentation.insights.diary

import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.R
import com.greemoid.ithelps.databinding.DiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import javax.inject.Inject

class InsightsDiaryViewHolder @Inject constructor(val binding: DiaryItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(note: DiaryNote) {
        with(binding) {
            tvTitleForDiaryNote.text =
                String.format(itemView.context.getString(R.string.what_happened), note.date)
            tvDiaryTextItem.text = note.description
        }
    }
}