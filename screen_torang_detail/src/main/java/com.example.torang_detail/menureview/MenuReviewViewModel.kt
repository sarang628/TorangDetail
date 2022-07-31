package com.example.torang_detail.menureview

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.torangrepository.TorangRepository
import com.example.torang_core.data.model.Menu
import com.example.torang_core.util.Logger
import com.example.torang_core.repository.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 메뉴 리뷰 뷰모델
 */
@HiltViewModel
class MenuReviewViewModel @Inject constructor(private val menuRepository: MenuRepository) : ViewModel() {
    // 메뉴 리스트
    var menuBodies = MutableLiveData<ArrayList<Menu>>()

    // 현재 선택 한 메뉴
    var currentMenu = MutableLiveData<Menu>()

    fun setCurrentMenu(currentMenu: Menu) {
        this.currentMenu.value = currentMenu
    }

    fun loadMenu(restaurantId: Int) {
        viewModelScope.launch {
            try {
                menuBodies.postValue(menuRepository.getMenus(restaurantId))
            } catch (e: Exception) {
                Logger.e(e.toString())
            }
        }

    }
}