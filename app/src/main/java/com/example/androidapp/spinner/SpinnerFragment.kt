package com.example.androidapp.spinner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentSpinnerBinding

class SpinnerFragment : Fragment() {
    var binding: FragmentSpinnerBinding? = null

    companion object {
        val TAG = "FragmentSpinnerTag"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentSpinnerBinding = FragmentSpinnerBinding.inflate(inflater, container, false)
        binding = fragmentSpinnerBinding
        return fragmentSpinnerBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()

        var spinner: Spinner? = view?.findViewById(R.id.fs_spinner)
        var adapter = view?.context?.let {
            ArrayAdapter.createFromResource(it,
                R.array.cities_array,
                android.R.layout.simple_spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                    spinner?.adapter
                }
        }

        spinner?.adapter = adapter
        spinner?.onItemSelectedListener = listener
        super.onViewCreated(view, savedInstanceState)
    }

    val listener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            Toast.makeText(context, (view as AppCompatTextView)?.text , Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>) {

        }
    }


    private fun setupViews() {
        setupToolbar()
    }

    private fun setupToolbar() {
        binding?.fetTbToolbar?.apply {
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            title = "Spinner"
        }
    }
}
