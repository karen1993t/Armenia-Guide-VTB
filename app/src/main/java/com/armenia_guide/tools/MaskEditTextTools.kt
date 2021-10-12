package com.armenia_guide.tools

import android.widget.EditText
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

object MaskEditTextTools {
    fun createMaskEdit(index: Int, array: Array<String>, editText: EditText) {
        val slots =
            PhoneNumberUnderscoreSlotsParser().parseSlots(array[index])
        val maskInput = MaskImpl.createTerminated(slots)
        val formatWatcher = MaskFormatWatcher(maskInput)
        formatWatcher.installOn(editText)
    }
}