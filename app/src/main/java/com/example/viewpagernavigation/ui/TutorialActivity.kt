package com.example.viewpagernavigation.ui

import androidx.appcompat.app.AppCompatActivity
import com.example.viewpagernavigation.R

class TutorialActivity: AppCompatActivity(R.layout.activity_tutorial) {

    override fun onBackPressed() {
        moveTaskToBack(true)
    }
}