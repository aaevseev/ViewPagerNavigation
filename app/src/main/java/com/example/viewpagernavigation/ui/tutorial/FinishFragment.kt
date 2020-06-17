package com.example.viewpagernavigation.ui.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.viewpagernavigation.R
import kotlinx.android.synthetic.main.fragment_finish_tutorial.*

class FinishFragment : Fragment(R.layout.fragment_finish_tutorial) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_finish.setOnClickListener {
            requireActivity().finish()
        }
    }
}