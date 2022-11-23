package com.example.androidapp.button

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentButtonBinding
import extension.toast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ButtonFragment : Fragment(), CoroutineScope {

    companion object {
        const val TAG = "ButtonFragmentTag"
    }

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    private var binding: FragmentButtonBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentButtonBinding = FragmentButtonBinding.inflate(inflater, container, false)
        binding = fragmentButtonBinding
        super.onCreateView(inflater, container, savedInstanceState)
        return fragmentButtonBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        binding?.fbPbProgressButton?.setOnClickListener {
            launch {
                binding?.fbPbProgressButton?.setProgressState(true)
                delay(3000)
                binding?.fbPbProgressButton?.setProgressState(false)
            }
        }
        binding?.buttonDrawable?.setOnClickListener {
            toast(msg = getString(R.string.click_button))
        }
    }

    private fun setupViews() {
        setupToolbar()

    }

    private fun setupToolbar() {
        binding?.fbTbToolbar?.apply {
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            title = getString(R.string.buttons_text)
        }
    }
}





