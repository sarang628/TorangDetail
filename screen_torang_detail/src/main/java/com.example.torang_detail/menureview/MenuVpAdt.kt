package com.example.torang_detail.menureview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.torang_core.data.model.Menu
import java.util.*

internal class MenuVpAdt(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private var menus = ArrayList<Menu>()
    override fun getItem(position: Int): Fragment {
        val menuSimpleFragment = MenuSimpleFragment()
        menuSimpleFragment.setMenuBody(menus[position])
        return menuSimpleFragment
    }

    override fun getCount(): Int {
        return menus.size
    }

    fun setMenus(menuBodies: ArrayList<Menu>) {
        menus = menuBodies
        notifyDataSetChanged()
    }
}