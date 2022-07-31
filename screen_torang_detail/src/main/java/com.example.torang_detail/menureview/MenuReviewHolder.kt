package com.example.torang_detail.menureview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.torang_detail.databinding.ItemMenuReviewBinding

class MenuReviewHolder(var itemMenuReviewBinding: ItemMenuReviewBinding) : RecyclerView.ViewHolder(
    itemMenuReviewBinding.root
) {
    companion object {
        fun create(parent: ViewGroup): MenuReviewHolder {
            return MenuReviewHolder(
                ItemMenuReviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}