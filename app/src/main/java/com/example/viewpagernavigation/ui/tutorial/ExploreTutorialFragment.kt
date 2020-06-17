package com.example.viewpagernavigation.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewpagernavigation.R
import kotlinx.android.synthetic.main.fragment_explore_tutorial.*

class ExploreTutorialFragment : Fragment(R.layout.fragment_explore_tutorial) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_next.setOnClickListener {
            findNavController().navigate(R.id.action_exploreFragment_to_finishFragment)
        }
    }
}