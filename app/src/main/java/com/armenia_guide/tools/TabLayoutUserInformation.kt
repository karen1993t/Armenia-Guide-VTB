package com.armenia_guide.tools

import com.google.android.material.tabs.TabLayout

object TabLayoutUserInformation {
    fun tabLayoutFragments(tabLayout: TabLayout) {
        with(tabLayout) {
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
        }
    }
}