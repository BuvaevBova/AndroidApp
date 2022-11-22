package com.example.androidapp.button

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.androidapp.R

class ProgressButton : FrameLayout {
    private lateinit var textPB: TextView
    private lateinit var progressPB: ProgressBar
    private var textOnButton: String? = ""
    private var textColor: Int = 0
    private var progressColor: Int = 0

    constructor(context: Context) : super(context) {
        prepare(null)
    }

    constructor(context: Context, attr: AttributeSet?) : super(context, attr) {
        prepare(attr)
    }

    constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) : super(
        context, attr, defStyleAttr
    ) {
        prepare(attr)
    }

    private fun prepare(attr: AttributeSet?) {
        initAttrs(attr)
        val view = LayoutInflater.from(context).inflate(R.layout.progress_button, this, true)
        textPB = view.findViewById(R.id.button)
        progressPB = view.findViewById(R.id.progress)
        textPB.text = textOnButton
        textPB.setTextColor(textColor)
        progressPB.indeterminateTintList = ColorStateList.valueOf(progressColor)
        setProgressState(false)
    }

    fun setProgressState(isProgress: Boolean) {
        textPB.isVisible = !isProgress
        progressPB.isVisible = isProgress

    }

    private fun initAttrs(attr: AttributeSet?) {
        if (attr != null) {
            val attribute = context.theme.obtainStyledAttributes(
                attr, R.styleable.ProgressButton, 0, 0
            )

            try {
                textOnButton = attribute.getString(R.styleable.ProgressButton_text)
                textColor = when {
                    attribute.hasValue(R.styleable.ProgressButton_text_color) -> {
                        attribute.getColor(
                            R.styleable.ProgressButton_text_color,
                            resources.getColor(R.color.black)
                        )
                    }
                    else -> {
                        resources.getColor(R.color.black)
                    }
                }

                progressColor = when {
                    attribute.hasValue(R.styleable.ProgressButton_progress_color) -> {
                        attribute.getColor(
                            R.styleable.ProgressButton_progress_color,
                            resources.getColor(R.color.black)
                        )
                    }
                    else -> {
                        resources.getColor(R.color.black)
                    }

                }
            } finally {
                attribute.recycle()
            }

        }
    }
}
