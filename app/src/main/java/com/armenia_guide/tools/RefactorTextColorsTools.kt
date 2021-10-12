package com.armenia_guide.tools

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

object RefactorTextColorsTools {

    fun refactorColorText(
        context: Context,
        textView: TextView,
        colorResources: Int,
        startIndex: Int,
        endIndex: Int
    ): SpannableStringBuilder {
        textView?.text.let { text ->
            return SpannableStringBuilder(text).apply {
                setSpan(
                    ForegroundColorSpan(context.resources.getColor(colorResources, null)),
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }
    }
}