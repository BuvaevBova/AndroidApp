package com.example.androidapp.toolbar_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentToolbarBinding
import com.example.androidapp.view.BaseFragment


class ToolbarFragment : BaseFragment() {
    companion object {
        const val TAG = "ToolbarFragmentTag"
    }

    private var fragmentAppBarBinding: FragmentToolbarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentToolbarBinding.inflate(inflater, container, false)
        fragmentAppBarBinding = binding
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun injectDependency() {
    }

    override fun initToolbar() {
        fragmentAppBarBinding?.toolbar?.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        fragmentAppBarBinding?.toolbar?.title = getString(R.string.collapsing_toolbar_layout_text)

    }

    override fun attachPresenter() {
    }

}