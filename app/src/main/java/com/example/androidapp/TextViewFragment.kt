package com.example.androidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapp.databinding.FragmentGeneralBinding
import com.example.androidapp.databinding.FragmentTextViewBinding

class TextViewFragment : Fragment() {
    var binding: FragmentTextViewBinding? = null

    companion object {
        val TAG = "FragmentTextViewTag"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentTextViewBinding = FragmentTextViewBinding.inflate(inflater, container, false)
        binding = fragmentTextViewBinding
        return fragmentTextViewBinding.root
    }
}