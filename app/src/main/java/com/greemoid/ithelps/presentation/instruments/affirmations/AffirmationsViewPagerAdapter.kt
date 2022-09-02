package com.greemoid.ithelps.presentation.instruments.affirmations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.greemoid.ithelps.R
import com.greemoid.ithelps.data.models.Affirmation
import java.util.*

class AffirmationsViewPagerAdapter(
    private val context: Context,
    private val affirmationsList: List<Affirmation>,
) : PagerAdapter() {
    override fun getCount(): Int = affirmationsList.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView =
            layoutInflater
                .inflate(R.layout.affirmations_slider_item_layout, container, false)


        val ivAffirmation = itemView.findViewById<ImageView>(R.id.ivAffirmation)
        ivAffirmation.alpha = 0.85f
        ivAffirmation.scaleType = ImageView.ScaleType.FIT_XY
        val tvAffirmation = itemView.findViewById<TextView>(R.id.tvAffirmation)

        ivAffirmation.setImageResource(affirmationsList[position].imageAffirmation)
        tvAffirmation.setText(affirmationsList[position].textAffirmation)

        Objects.requireNonNull(container).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}