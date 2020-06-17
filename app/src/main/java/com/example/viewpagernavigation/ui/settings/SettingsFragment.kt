package com.example.viewpagernavigation.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.viewpagernavigation.ui.MainActivity
import com.example.viewpagernavigation.R
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(R.layout.fragment_settings) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_privacy_settings.setOnClickListener {
            findNavController().navigate(R.id.action_privacy_settings)
        }

        btn_profile_settings.setOnClickListener {
            findNavController().navigate(R.id.action_profile_settings)
        }

        findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.privacy_settings_dest,
                R.id.profile_settings_dest -> {
                    (activity as MainActivity).hideBottom()
                }
                else -> {
                    (activity as MainActivity).showBottom()
                }
            }
        }
    }
}
