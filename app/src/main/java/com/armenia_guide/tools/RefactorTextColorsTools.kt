package com.armenia_guide.tools

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.armenia_guide.R

object RefactorTextColorsTools {


    fun refactorColorText(
        context: Context,
        textView: TextView?,
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

    fun textPrivacyPolicy(context: Context): SpannableStringBuilder {
        val textPrivacyPolicy = context.resources.getText(R.string.text_privacy_policy)
        var text = SpannableStringBuilder(textPrivacyPolicy).apply {
            setSpan(
                ForegroundColorSpan(context.resources.getColor(R.color.color_red, null)), 13,
                42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        text =  SpannableStringBuilder(text).apply {
            setSpan(
                ForegroundColorSpan(context.resources.getColor(R.color.color_red, null)), 44,
                text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

        }
        return text
    }
}