package com.example.torang_detail.menureview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.torang_core.data.model.Menu
import com.example.torang_detail.R
import com.example.torang_detail.databinding.ItemMenuRatingBinding

/**
 * A simple [Fragment] subclass.
 */
class MenuSimpleFragment : Fragment() {
    var mBinding: ItemMenuRatingBinding? = null
    //var menuBody: Menu? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_menu_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = ItemMenuRatingBinding.bind(view)
        mBinding!!.lifecycleOwner = this
        /*if (menuBody != null) {
            mBinding!!.menu = menuBody
        }*/
    }

    fun setMenuBody(menuBody: Menu?) {
        //this.menuBody = menuBody
    }
}