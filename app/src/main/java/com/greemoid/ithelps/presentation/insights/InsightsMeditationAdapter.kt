package com.greemoid.ithelps.presentation.insights

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.ithelps.databinding.InsightsMeditationItemLayoutBinding
import com.greemoid.ithelps.domain.models.meditation.Meditation

class InsightsMeditationAdapter :
    RecyclerView.Adapter<InsightsMeditationAdapter.MeditationViewHolder>() {
    inner class MeditationViewHolder(private val binding: InsightsMeditationItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Meditation) {
            binding.tvMeditationOrBreathing.text = "Медитація"
            binding.tvTimeMeditationItem.text = item.sessionTime.toString()
            binding.tvDateOfMeditationItem.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationViewHolder {
        val binding =
            InsightsMeditationItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return MeditationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeditationViewHolder, position: Int) {
        val item = meditationList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        if (meditationList.size > limit) {
            return limit
        } else {
            return meditationList.size
        }
    }

    private val limit = 3

    var meditationList = emptyList<Meditation>()

    fun submitList(list: List<Meditation>) {
        meditationList = list
        notifyDataSetChanged()
    }


}