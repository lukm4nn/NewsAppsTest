package com.example.newsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thegamers.newsappstest.fragment.*
import com.thegamers.newsappstest.utils.Constants.TOTAL_NEWS_TAB

class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int = TOTAL_NEWS_TAB

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> {
                return UmumFragment()
            }
            1 -> {
                return BisnisFragment()
            }
            2 -> {
                return EntertaimentFragment()
            }
            3 -> {
                return IlmuPengetahuanFragment()
            }
            4 -> {
                return OlahRagaFragment()
            }
            5 -> {
                return TeknologiFragment()
            }
            6 -> {
                return KesehatanFragment()
            }

            else -> return BisnisFragment()

        }
    }
}