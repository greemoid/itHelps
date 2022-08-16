package com.greemoid.ithelps.presentation.insights

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.InsightsDiaryItemLayoutBinding
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class InsightsDiaryAdapter : RecyclerView.Adapter<InsightsDiaryAdapter.InsightsDiaryViewHolder>() {
    inner class InsightsDiaryViewHolder(val binding: InsightsDiaryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var diaryList = emptyList<DiaryNote>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsightsDiaryViewHolder {
        val binding = InsightsDiaryItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return InsightsDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsightsDiaryViewHolder, position: Int) {
        val note = diaryList[position]
        with(holder.binding) {
            tvDateItem.text = note.date
            tvDiaryTextItem.text = note.description
        }
    }

    override fun getItemCount(): Int {
        if (diaryList.size > limit) {
            return limit
        } else {
            return diaryList.size
        }
    }


    private val limit = 3

    fun submitList(list: List<DiaryNote>) {
        diaryList = list
        notifyDataSetChanged()
    }
}