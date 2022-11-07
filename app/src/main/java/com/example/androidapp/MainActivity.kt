package com.example.androidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openGeneralFragment()
    }

    private fun openGeneralFragment() {
        supportFragmentManager.commit {
            add<GeneralFragment>(R.id.am_fcv_fragment_container)
            setReorderingAllowed(true)
            addToBackStack(GeneralFragment.TAG)
        }
    }

    fun openTextViewFragment() {
        supportFragmentManager.commit {
            replace<TextViewFragment>(R.id.am_fcv_fragment_container)
            setReorderingAllowed(true)
            addToBackStack(GeneralFragment.TAG)
        }
    }
}