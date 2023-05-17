package com.example.android_practice.custom_view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.android_practice.R

class ButtonWithProgressBar: FrameLayout {

    private lateinit var rlRootLayout: FrameLayout
    private lateinit var tvText: TextView
    private lateinit var pbLoader: ProgressBar
    private var text = ""
    private var size = ButtonWithProgressBarSize.DEFAULT
    private var isButtonEnabled = true
    private var backgroundColour = 0
    private var textColor = 0
    private var showingLoader = false

    constructor(context: Context): super(context){
        initButtonWithProgressBar(context)
    }
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        getDataFromXML(attrs, context)
        initButtonWithProgressBar(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttrs: Int): super(context, attrs, defStyleAttrs) {
        getDataFromXML(attrs, context)
        initButtonWithProgressBar(context)
    }

    enum class ButtonWithProgressBarSize() {
        DEFAULT, MINI, LARGE, LARGEST
    }

    private fun getDataFromXML(attrs: AttributeSet?, context: Context) {
        val data = context.obtainStyledAttributes(attrs, R.styleable.ButtonWithProgressBar)
        text = data.getString(R.styleable.ButtonWithProgressBar_text).toString()
        isButtonEnabled = data.getBoolean(R.styleable.ButtonWithProgressBar_enabled, true)
        backgroundColour = data.getColor(R.styleable.ButtonWithProgressBar_backgroundColor, context.resources.getColor(R.color.blue_bank))
        textColor = data.getColor(R.styleable.ButtonWithProgressBar_custom_text_color, context.resources.getColor(R.color.white))

        when (data.getInt(R.styleable.ButtonWithProgressBar_size, 0)) {
            0 -> ButtonWithProgressBarSize.DEFAULT
            1 -> ButtonWithProgressBarSize.MINI
            2 -> ButtonWithProgressBarSize.LARGE
            3 -> ButtonWithProgressBarSize.LARGEST
        }
        data.recycle()
    }
    private fun initButtonWithProgressBar(context: Context) {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        LayoutInflater.from(context).inflate(R.layout.button_with_progress_bar, this, true)
        rlRootLayout = findViewById(R.id.rl_root_layout)
        tvText = findViewById(R.id.tv_progress)
        pbLoader = findViewById(R.id.pb_loader)
        if (text.isNotEmpty()) {
            tvText.text = text
        }

        minimumWidth = resources.getDimension(R.dimen.dp_80).toInt()

        when (size) {
            ButtonWithProgressBarSize.MINI -> {
                setMeasuredDimension(measuredWidth, resources.getDimension(R.dimen.dp_40).toInt())
                rlRootLayout.layoutParams.height = resources.getDimension(R.dimen.dp_40).toInt()
            }
            ButtonWithProgressBarSize.LARGE -> {
                setMeasuredDimension(measuredWidth, resources.getDimension(R.dimen.dp_50).toInt())
                rlRootLayout.layoutParams.height = resources.getDimension(R.dimen.dp_50).toInt()
            }
            ButtonWithProgressBarSize.LARGEST -> {
                setMeasuredDimension(measuredWidth, resources.getDimension(R.dimen.dp_60).toInt())
                rlRootLayout.layoutParams.height = resources.getDimension(R.dimen.dp_60).toInt()
            }
            else -> {
                setMeasuredDimension(measuredWidth, resources.getDimension(R.dimen.dp_40).toInt())
                rlRootLayout.layoutParams.height = resources.getDimension(R.dimen.dp_40).toInt()
            }
        }

        rlRootLayout.setPadding(resources.getDimension(R.dimen.dp_10).toInt(), 0, resources.getDimension(R.dimen.dp_10).toInt(), 0)

        refreshDrawableState()
    }

    fun setText(text: String) {
        tvText.text = text
    }
    fun showLoader() {
        showingLoader = true
        tvText.visibility = View.GONE
        pbLoader.visibility = View.VISIBLE
    }
    fun hideLoader() {
        showingLoader = false
        tvText.visibility = View.VISIBLE
        pbLoader.visibility = View.GONE
    }
}