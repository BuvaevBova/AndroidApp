package com.example.androidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapp.databinding.FragmentGeneralBinding

class GeneralFragment : Fragment() {
    var binding: FragmentGeneralBinding? = null

    companion object {
        val TAG = "GeneralFragmentTeg"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentGeneralBinding = FragmentGeneralBinding.inflate(inflater, container, false)
        binding = fragmentGeneralBinding
        return fragmentGeneralBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.fgBtnTextViewFragment?.setOnClickListener { (activity as? MainActivity)?.openTextViewFragment() }
        binding?.fgBtnEditText?.setOnClickListener { (activity as? MainActivity)?.openEditTextFragment() }
        binding?.fgBtnButton?.setOnClickListener { (activity as? MainActivity)?.openButtonFragment() }
        binding?.fgBtnAppBar?.setOnClickListener { (activity as? MainActivity)?.openAppBarFragment() }
        binding?.fgBtnToolbar?.setOnClickListener { (activity as? MainActivity)?.openToolbarFragment() }
        binding?.fgBtnSpinner?.setOnClickListener { (activity as? MainActivity)?.openSpinnerFragment() }
    }
}