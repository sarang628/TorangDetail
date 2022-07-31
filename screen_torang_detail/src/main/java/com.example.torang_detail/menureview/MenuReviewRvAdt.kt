package com.example.torang_detail.menureview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.torang_core.data.model.MenuReview
import com.sarang.screen_reviews.ReviewPicturesRvAdt
import java.util.*

class MenuReviewRvAdt : RecyclerView.Adapter<MenuReviewHolder>() {
    private var menuReviews = ArrayList<MenuReview>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuReviewHolder {
        return MenuReviewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MenuReviewHolder, position: Int) {
        holder.itemMenuReviewBinding.menuReview = menuReviews[position]
        val reviewPicturesRvAdt: ReviewPicturesRvAdt = object : ReviewPicturesRvAdt() {
            override fun clickPicture(position: Int) {}
        }
//        reviewPicturesRvAdt.setPictureBodies(menuReviews.get(position).pictures);
//        holder.itemMenuReviewBinding.recyclerView.setAdapter(reviewPicturesRvAdt);
    }

    override fun getItemCount(): Int {
        return menuReviews.size
    }

    fun setMenuReviews(menuReviewBodies: ArrayList<MenuReview>?) {
        if (menuReviewBodies == null) return
        menuReviews = menuReviewBodies
        notifyDataSetChanged()
    }
}