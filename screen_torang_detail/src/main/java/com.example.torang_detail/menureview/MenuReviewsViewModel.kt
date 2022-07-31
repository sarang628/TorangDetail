package com.example.torang_detail.menureview

import android.app.Application
import androidx.lifecycle.*
import com.example.torang_core.data.model.MenuReview
import com.example.torang_core.data.model.Menu
import com.example.torang_core.data.model.User
import java.util.ArrayList

class MenuReviewsViewModel : ViewModel() {
    val menuId = MutableLiveData<Int>()
    val position = MutableLiveData<Int>()
    val menuReviews = MutableLiveData<ArrayList<MenuReview>>()
    private val clickUser = MutableLiveData<User>()
    fun setPosition(position: Int) {
        this.position.value = position
    }

    fun loadMenuReviews() {
        //if (menuId.getValue() != null)
    }

    fun setMenuReviews(menuReviews: ArrayList<MenuReview>) {
        this.menuReviews.value = menuReviews
    }

    fun setCurrentMenu(menuBody: Menu) {
        menuId.value = menuBody.menu_id
        loadMenuReviews()
    }

    fun observeClickUser(lifecycleOwner: LifecycleOwner?, observer: Observer<User>?) {
        clickUser.observe(lifecycleOwner!!, observer!!)
    }
}