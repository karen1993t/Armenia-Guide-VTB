package com.armenia_guide.tools

import androidx.core.content.ContentProviderCompat.requireContext
import com.armenia_guide.R

object ConstantsTools {
    /** Format DatePicker **/
    const val FORMAT_DATE = "dd.MM.yyyy"
    const val FILENAME_DATE_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    /** Position fragments Personal information **/
    const val PERSONAL_INFORMATION_POSITION = 0
    const val PHONE_NUMBER_POSITION = 1
    const val USER_ADDRESS = 2
    const val USER_PASSPORT = 3
    const val COMMUNICATION_WITH_THE_BANK = 4

    /** Position fragments register and login  user **/
    const val REGISTER_USER_POSITION = 0
    const val LOGIN_USER_POSITION = 1
    const val RESET_PASSWORD_POSITION = 2
    const val NEW_PASSWORD_POSITION = 3
    const val EMAIL_CONFIRM_POSITION = 4

    /** EditText empty  error  **/
    const val ERROR_EDIT_TEXT = "Поле ввода не должно быть пустым"

}