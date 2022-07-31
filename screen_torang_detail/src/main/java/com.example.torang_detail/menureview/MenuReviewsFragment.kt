package com.example.torang_detail.menureview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.torang_detail.databinding.MenuReviewsFragmentBinding
import com.example.torang_core.data.model.MenuReview
import java.util.*

/**
 * 메뉴 리뷰들을 보는 프레그먼트
 * 상단에 메뉴와 하단에 메뉴리뷰들이 나오는 화면
 */
class MenuReviewsFragment : Fragment() {
    // 뷰모델
    private val mViewModel: MenuReviewsViewModel by viewModels()

    // 데이터바인딩
    lateinit var mBinding: MenuReviewsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 바인딩 초기화
        mBinding = MenuReviewsFragmentBinding.inflate(layoutInflater, container, false)
        // 메뉴 리뷰 어뎁터 셋팅
        mBinding.rvMenuReviews.adapter = MenuReviewRvAdt()
        // 메뉴 아답터 셋팅
        mBinding.vpMenu.adapter =
            MenuVpAdt(childFragmentManager)
        // 메뉴 페이지 이동 시 이벤트 설정
        mBinding.vpMenu.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(position: Int,
                positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mViewModel.setPosition(position)
                //mViewModel.setCurrentMenu(menuReviewViewModel.getMenuBodies().value!![position])
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        // UI 구독 함수 호출
        subScribeUi()

        return mBinding.root
    }

    private fun subScribeUi() {
        /*menuReviewViewModel.menuBodies
            .observe(requireActivity(), { menuBodies: ArrayList<Menu> ->
                (mBinding.vpMenu.adapter as MenuVpAdt).setMenus(menuBodies)
            })

        menuReviewViewModel.currentMenu
            .observe(requireActivity(), { menuBody: Menu? -> mViewModel.setCurrentMenu(menuBody) })*/

        //클릭한 아이템 포지션으로 페이저 이동 시키기
        mViewModel.position.observe(
            requireActivity(),
            { position: Int -> mBinding.vpMenu.currentItem = position })

        mViewModel.menuReviews.observe(
            requireActivity(),
            { menuReviews: ArrayList<MenuReview> ->
                (mBinding.rvMenuReviews.adapter as MenuReviewRvAdt).setMenuReviews(menuReviews)
            })

    }
}