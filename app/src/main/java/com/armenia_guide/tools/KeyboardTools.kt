package com.armenia_guide.tools

import android.content.Context
import android.view.inputmethod.InputMethodManager


object KeyboardTools {
    private var keyboard: InputMethodManager? = null
    fun showKeyboard(context: Context) {
        keyboard = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard?.toggleSoftInput(InputMethodManager.RESULT_SHOWN, 0)
    }

    fun hideKeyboard() {
        keyboard?.toggleSoftInput(InputMethodManager.RESULT_UNCHANGED_HIDDEN,0)
    }
}