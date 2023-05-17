package com.example.torang_detail.menureview

/**
 * 메뉴 리뷰 뷰모델
 */
//@HiltViewModel
//class MenuReviewViewModel @Inject constructor(private val menuRepository: MenuRepository) : ViewModel() {
//    // 메뉴 리스트
//    var menuBodies = MutableLiveData<ArrayList<Menu>>()
//
//    // 현재 선택 한 메뉴
//    var currentMenu = MutableLiveData<Menu>()
//
//    fun setCurrentMenu(currentMenu: Menu) {
//        this.currentMenu.value = currentMenu
//    }
//
//    fun loadMenu(restaurantId: Int) {
//        viewModelScope.launch {
//            try {
//                menuBodies.postValue(menuRepository.getMenus(restaurantId))
//            } catch (e: Exception) {
//                Logger.e(e.toString())
//            }
//        }
//
//    }
//}