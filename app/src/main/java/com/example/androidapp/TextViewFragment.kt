package com.example.androidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        binding?.longText?.post {
            binding?.longText?.lineCount?.let { lineCount ->
                if (lineCount <= 4) {
                    binding?.readFull?.visibility = View.GONE
                } else {
                    binding?.longText?.visibility = View.VISIBLE
                }
            }
        }
        binding?.readFull?.setOnClickListener{
            binding?.longText?.maxLines = Int.MAX_VALUE
            binding?.readFull?.visibility=View.GONE
        }
    }

    private fun setupViews() {
        setupToolbar()

    }

    private fun setupToolbar() {
        binding?.ftvTbToolbar?.apply {
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            title = getString(R.string.text_view_label)
        }
    }
}