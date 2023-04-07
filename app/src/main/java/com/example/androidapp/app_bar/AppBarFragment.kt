package com.example.androidapp.app_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentAppBarBinding
import extension.toast


class AppBarFragment : Fragment() {
    companion object {
        const val TAG = "AppBarFragmentTag"
    }

    private var fragmentAppBarBinding: FragmentAppBarBinding? = null
    private val isLiked = false

    private val presenter = AppPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentAppBarBinding.inflate(inflater, container, false)
        fragmentAppBarBinding = binding
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        setupView()
        fragmentAppBarBinding?.toolbar?.inflateMenu(R.menu.menu_app_bar)
        fragmentAppBarBinding?.toolbar?.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    private fun setupView() {
        setupToolbar()
    }

    private fun setupToolbar() {
        fragmentAppBarBinding?.toolbar?.apply {
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            title = "App Bar"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_like -> {
                toast("Like")
            }
        }
        return true
    }
}




