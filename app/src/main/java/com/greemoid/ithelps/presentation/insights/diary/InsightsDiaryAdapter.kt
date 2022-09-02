package com.greemoid.ithelps.presentation.insights.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.InsightsDiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class InsightsDiaryAdapter(private val limit: Int) : RecyclerView.Adapter<InsightsDiaryAdapter.InsightsDiaryViewHolder>() {
    inner class InsightsDiaryViewHolder(val binding: InsightsDiaryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: DiaryNote) {
            with(binding) {
                tvDateItem.text = note.date
                tvDiaryTextItem.text = note.description
            }
        }
    }

    var diaryList = emptyList<DiaryNote>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsightsDiaryViewHolder {
        val binding = InsightsDiaryItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return InsightsDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsightsDiaryViewHolder, position: Int) =
        holder.bind(diaryList[position])


    override fun getItemCount(): Int {
        return if (diaryList.size > limit && limit != 0) {
            limit
        } else {
            diaryList.size
        }
    }

    fun submitList(list: List<DiaryNote>) {
        diaryList = list
        notifyDataSetChanged()
    }
}