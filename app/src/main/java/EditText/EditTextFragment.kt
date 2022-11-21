package EditText

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentEditTextBinding

class EditTextFragment : Fragment() {
    var binding: FragmentEditTextBinding? = null

    companion object {
        val TAG = "FragmentEditTextTag"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val fragmentEditTextBinding = FragmentEditTextBinding.inflate(inflater, container, false)
        binding = fragmentEditTextBinding
        return fragmentEditTextBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        binding?.loginBtn?.isEnabled = false
        binding?.loginBtn?.setOnClickListener {
            binding?.loginText?.text = binding?.fetTietLogin?.text
            binding?.textPassword?.text = binding?.fetTietPassword?.text
        }

        binding?.fetTietLogin?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding?.loginBtn?.isEnabled =
                    charSequence?.isNotEmpty() == true && binding?.fetTietPassword?.text?.isNotEmpty() == true
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding?.fetTietPassword?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding?.loginBtn?.isEnabled =
                    charSequence?.isNotEmpty() == true && binding?.fetTietPassword?.text?.isNotEmpty() == true
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding?.inputEd?.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding?.focusTv?.text = getString(R.string.has_focus)
            } else {
                binding?.focusTv?.text = getString(R.string.has_not_focus)
            }
        }
        binding?.inputEd?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding?.etResult?.text = binding?.inputEd?.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun setupViews() {
        setupToolbar()
    }

    private fun setupToolbar() {
        binding?.fetTbToolbar?.apply {
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            title = "Edit Text"
        }
    }
}