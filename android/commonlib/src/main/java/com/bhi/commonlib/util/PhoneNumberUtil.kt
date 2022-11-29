package com.bhi.commonlib.util

import android.text.InputFilter
import android.text.TextUtils

/**
 * Utility class for phone number formatting etc.
 */
object PhoneNumberUtil {

    val phoneNumberInputFilter = InputFilter { source, _, _, span, dstart, dend ->
        if (source.length > 1) {
            //if phone number is set using setText() method at once, instead of, typing individual characters from EditText.
            return@InputFilter formatPhoneNumber(extractDigits(source.toString()))
        } else if (source.isNotEmpty()) {
            if (!Character.isDigit(source[0]))
                return@InputFilter ""
            else {
                when {
                    dstart == 0 -> {
                        return@InputFilter "($source"
                    }
                    dstart == 3 -> return@InputFilter "$source)"
                    dstart == 4 -> return@InputFilter ") $source"
                    dstart == 5 -> return@InputFilter " $source"
                    dstart == 9 -> return@InputFilter "-$source"
                    dstart >= 14 -> return@InputFilter ""
                    else -> {
                    }
                }
            }
        }
        null
    }


    fun formatPhoneNumber(phoneNumber: String?): String? {
        if (TextUtils.isEmpty(phoneNumber)) {
            return null
        }

        val stringBuffer = StringBuffer()

        phoneNumber?.forEachIndexed { index, ch ->
            when {
                index == 0 -> stringBuffer.append("($ch")
                index == 2 -> stringBuffer.append("$ch)")
                index == 3 -> stringBuffer.append(" $ch")
                index == 6 -> stringBuffer.append("-$ch")
                index >= 14 -> stringBuffer.append("")
                else -> stringBuffer.append(ch)
            }
        }

        return stringBuffer.toString()
    }


    fun extractDigits(string: String?): String? {
        return string?.replace("[^0-9]".toRegex(), "")
    }


}