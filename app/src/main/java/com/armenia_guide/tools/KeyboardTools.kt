package com.armenia_guide.tools

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

object KeyboardTools {
   private lateinit var keyboard:InputMethodManager
    fun showKeyboard( context: Context) {
         keyboard=context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.toggleSoftInput(InputMethodManager.RESULT_SHOWN,0)
    }

    fun hideKeyboard( context: Context) {
        keyboard.toggleSoftInput(InputMethodManager.RESULT_UNCHANGED_HIDDEN,0)
    }
}