package com.bhi.commonlib.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.net.Uri
import android.os.Build
import android.telephony.PhoneNumberUtils
import android.text.*
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.bhi.commonlib.Dimension
import com.bhi.commonlib.R
import java.math.BigDecimal
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.math.ceil


/**
 * @author Rahul Rastogi
 *
 * A utility class provides some common methods.
 */
object Util {

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (target == null) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target)
                .matches()
        }
    }

    fun getFullDeviceDimension(): Dimension {
        val displayMetrics = Resources.getSystem().displayMetrics
        return Dimension(displayMetrics.widthPixels, displayMetrics.heightPixels)
    }

    fun getFullDeviceMaxDimension(): Int {
        val displayMetrics = Resources.getSystem().displayMetrics

        return if (displayMetrics.widthPixels > displayMetrics.heightPixels)
            displayMetrics.widthPixels
        else
            displayMetrics.heightPixels
    }

    fun getDeviceDimension(activity: Activity): Dimension {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return Dimension(displayMetrics.widthPixels, displayMetrics.heightPixels)
    }


    fun getDeviceMaxDimension(activity: Activity): Int {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)

        return if (displayMetrics.widthPixels > displayMetrics.heightPixels)
            displayMetrics.widthPixels
        else
            displayMetrics.heightPixels
    }


    fun getDeviceHeight(activity: Activity): Int {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)

        return displayMetrics.heightPixels
    }

    fun getScreenDensity(context: Context) = context.resources.displayMetrics.densityDpi

    fun round(number: Float, decimalPoint: Int): Float {
        if (decimalPoint <= 0) {
            return number.toInt().toFloat()
        }
        val pow = Math.pow(10.0, decimalPoint.toDouble()).toInt()
        val valueMul = Math.round(number * pow)
        return valueMul.toFloat() / pow.toFloat()
    }

    fun hasFraction(value: Double): Boolean {
        return value != Math.ceil(value)
    }

    fun setStatusBarColorRes(activity: Activity, @ColorRes colorResID: Int) {
        setStatusBarColor(activity, ContextCompat.getColor(activity, colorResID))
    }


    fun setStatusBarColor(activity: Activity, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun setStatusBarColorByColor(activity: Activity, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun getStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            context.resources.getDimensionPixelSize(resourceId)
        } else {
            ceil((if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) 24 else 25) * context.resources.displayMetrics.density).toInt()
        }
    }

    fun capitalizeFirstChar(input: String?): String {
        if (TextUtils.isEmpty(input)) {
            return ""
        }
        return input!!.substring(0, 1).uppercase(Locale.getDefault()) + input.substring(1)
    }

    fun setTextColors(
        textView: TextView, startText: String, endText: String, startColor: Int,
        endColor: Int
    ) {
        val word = SpannableString(startText)
        word.setSpan(
            ForegroundColorSpan(startColor),
            0,
            word.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = word

        val wordTwo = SpannableString(endText)
        wordTwo.setSpan(
            ForegroundColorSpan(endColor),
            0,
            wordTwo.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.append(wordTwo)
    }


    fun setTextColors(
        textView: TextView, startText: String, middleText: String, endText: String,
        startColor: Int, middleColor: Int, endColor: Int
    ) {
        val word = SpannableString(startText)
        word.setSpan(
            ForegroundColorSpan(startColor),
            0,
            word.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = word

        val wordTwo = SpannableString(middleText)
        wordTwo.setSpan(
            ForegroundColorSpan(middleColor),
            0,
            wordTwo.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.append(wordTwo)

        val wordThree = SpannableString(endText)
        wordThree.setSpan(
            ForegroundColorSpan(endColor),
            0,
            wordThree.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.append(wordThree)
    }

    fun <T> join(delimiter: Char, arr: Array<T>?): String {
        if (null == arr || arr.isEmpty()) {
            return ""
        }

        var join = ""

        for (value in arr) {
            join += delimiter.toString() + value
        }

        return join.substring(1)
    }


    fun showCallDialer(context: Context, phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(callIntent)
    }

    fun isAppInstalled(context: Context, packageName: String): Boolean {
        return try {
            context.packageManager.getPackageInfo(packageName, 0)
            true
        } catch (ex: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun showEmailApp(context: Context, emailId: String) {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailId))

        if (emailIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(Intent.createChooser(emailIntent, ""))
        } else {
            MyToast.makeText(context, R.string.msg_email_supported_app_is_not_found)
        }
    }

    fun hasPhoneCallFeature(context: Context) =
        context.packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)

    fun formatPriceAndAppendKAtEnd(price: Long): String {
        return String.format("$%dK", price.toInt() / 1000)
    }

    fun formatPrice(price: Long): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        format.maximumFractionDigits = 0
        format.minimumFractionDigits = 0
        format.currency = Currency.getInstance(Locale.US)
        return format.format(price)
    }

    fun formatPrice(price: Float): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        format.maximumFractionDigits = 0
        format.minimumFractionDigits = 0
        format.currency = Currency.getInstance(Locale.US)
        return format.format(price)
    }

    fun formatNumber(price: Float, maxFractionDigit: Int = 1): String {
        val format = NumberFormat.getInstance(Locale.US)
        format.maximumFractionDigits = maxFractionDigit
        format.minimumFractionDigits = 0
        return format.format(price)
    }

    fun formatNumber(price: Long): String {
        val format = NumberFormat.getInstance(Locale.US)
        format.maximumFractionDigits = 0
        format.minimumFractionDigits = 0
        return format.format(price)
    }

    fun formatServerDate(date: String?): String? {
        val serverDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val serverDate = serverDateFormat.parse(date)

        val appDateFormat = SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.US)
        return appDateFormat.format(serverDate)
    }

    fun formatServerDateToMmDdYyyy(date: String?): String? {
        val serverDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val serverDate = serverDateFormat.parse(date)

        val appDateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        return appDateFormat.format(serverDate)
    }

    fun isVideoUrl(url: String?): Boolean {
        if (null == url) {
            return false
        }
        val videoUrl = url.trim().lowercase(Locale.US)
        return videoUrl.endsWith("mov") || videoUrl.endsWith("mp4") || videoUrl.endsWith("mpeg") || videoUrl.endsWith(
            "mpeg4"
        )
    }

    fun capitalizeWords(sentenceString: String?): String? {
        if (TextUtils.isEmpty(sentenceString)) {
            return null
        }

        val strArray = sentenceString!!.trim().split(" ".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val builder = StringBuilder()

        for (str in strArray) {
            val value = str.trim()
            if (TextUtils.isEmpty(value)) {
                continue
            }

            val cap = value.substring(0, 1).uppercase(Locale.US) + value.substring(1)
            builder.append("$cap ")
        }
        return builder.toString().trim()
    }

    fun formatUSAPhoneNumber(rawPhone: String?): String? {
        if (TextUtils.isEmpty(rawPhone)) return null

        val countryISO = "US"
        return PhoneNumberUtils.formatNumber(rawPhone, countryISO)
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

    fun textToBitmap(text: String, textSize: Float, textColor: Int): Bitmap {
        val paint = Paint(ANTI_ALIAS_FLAG)
        paint.textSize = textSize
        paint.color = textColor
        paint.textAlign = Paint.Align.LEFT

        val baseline = -paint.ascent() // ascent() is negative
        val width = (paint.measureText(text) + 0.0f)
        val height = (baseline + paint.descent() + 0.0f)
        val bitmap = Bitmap.createBitmap(width.toInt(), height.toInt(), Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)
        canvas.drawText(text, 0F, baseline, paint)
        return bitmap
    }

    val personNameInputFilter = InputFilter { source, start, end, dest, dstart, dend ->
        val allowedSymbols = arrayOf('\'', ',', '.', '-')
        var filteredText = ""

        for (index in start until end) {
            val ch = source.toString()[index]

            if (Character.isLetter(ch) || Character.isSpaceChar(ch) || ch in allowedSymbols) {
                filteredText += ch
            }
        }

        filteredText
    }

    val allowAllInputFilter = InputFilter { source, start, end, dest, dstart, dend ->
        var filteredText = ""

        for (index in start until end) {
            val ch = source.toString()[index]
            filteredText += ch
        }
        filteredText
    }


    fun fromHtml(htmlString: String?): Spanned? {
        return when {
            null == htmlString -> return null
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> Html.fromHtml(
                htmlString,
                Html.FROM_HTML_MODE_LEGACY
            )
            else -> Html.fromHtml(htmlString)
        }
    }

    fun getCommunityCodeArgumentName(stringUrl: String): String? {
        return if (TextUtils.isEmpty(stringUrl)) {
            null
        } else {
            val uri = Uri.parse(stringUrl)
            val args = uri.queryParameterNames
            var argument: String? = null
            (args.forEach { arg ->
                if (arg.lowercase(Locale.US) == "communitycode") {
                    argument = arg
                }
            })
            return argument
        }
    }

    fun getCommunityCodeFromCommunityUrl(stringUrl: String): String? {
        val arg = getCommunityCodeArgumentName(stringUrl)
        return if (arg != null) {
            val uri = Uri.parse(stringUrl)
            return uri.getQueryParameter(arg)
        } else {
            null
        }
    }

    fun truncateTrailingZeros(decimalString: Float): BigDecimal {
        return BigDecimal(decimalString.toString()).stripTrailingZeros()
    }

    fun getSpanned(stringText: String?): Spanned {
        return trimSpannable(
            HtmlCompat.fromHtml(
                stringText?.trim()
                    ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        )
    }

    fun getSpanned(
        title: String,
        value: String,
        titleFont: Typeface,
        valueFont: Typeface,
        titleColor: Int,
        valueColor: Int
    ): Spanned {
        val spannableStringBuilder = SpannableStringBuilder("$title $value")
        spannableStringBuilder.setSpan(
            CustomTypefaceSpan(titleFont),
            0,
            title.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringBuilder.setSpan(
            ForegroundColorSpan(titleColor),
            0,
            title.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringBuilder.setSpan(
            CustomTypefaceSpan(valueFont),
            title.length + 1,
            spannableStringBuilder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableStringBuilder.setSpan(
            ForegroundColorSpan(valueColor),
            title.length + 1,
            spannableStringBuilder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannableStringBuilder
    }

    fun getSpanned(text: String, color: Int, typeface: Typeface? = null): Spanned {
        val spannableStringBuilder = SpannableStringBuilder(text)
        spannableStringBuilder.setSpan(
            ForegroundColorSpan(color),
            0,
            spannableStringBuilder.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        if (typeface != null)
            spannableStringBuilder.setSpan(
                CustomTypefaceSpan(typeface),
                0,
                spannableStringBuilder.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        return spannableStringBuilder
    }

    private fun trimSpannable(spanned: Spanned): SpannableStringBuilder {
        val spannable = SpannableStringBuilder(spanned)
        var trimStart = 0
        var trimEnd = 0

        var text = spannable.toString()

        while (text.isNotEmpty() && text.startsWith("\n")) {
            text = text.substring(1)
            trimStart += 1
        }

        while (text.isNotEmpty() && text.endsWith("\n")) {
            text = text.substring(0, text.length - 1)
            trimEnd += 1
        }

        return spannable.delete(0, trimStart).delete(spannable.length - trimEnd, spannable.length)
    }

    fun makeLinks(
        text: String,
        linkTextColor: Int,
        vararg links: Pair<String, View.OnClickListener>
    ): Spannable {
        val spannableString = SpannableString(text)
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = linkTextColor
                }
            }
            val startIndexOfLink = text.indexOf(link.first)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return spannableString
    }


    fun makeLinks(text: String, vararg links: Pair<String, View.OnClickListener>): Spannable {
        val spannableString = SpannableString(text)
        for (link in links) {
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(view: View) {
                    Selection.setSelection((view as TextView).text as Spannable, 0)
                    view.invalidate()
                    link.second.onClick(view)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.isUnderlineText = true
                }
            }
            val startIndexOfLink = text.indexOf(link.first)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return spannableString
    }

    fun hasSpecialCharacter(s: String?): Boolean {
        if (s == null || s.trim().isEmpty()) {
            return false
        }

        val pattern = Pattern.compile("[^A-Za-z0-9]")
        val matcher = pattern.matcher(s)
        return matcher.find()
    }

    fun <T> handleUnCheckedCast(inList: List<T?>?): List<T>? {
        return if (inList == null) {
            null
        } else {
            val outList = arrayListOf<T>()
            for (item in inList) {
                if (item != null) {
                    outList.add(item)
                }
            }
            outList
        }
    }

    fun extractDigits(string: String?): String? {
        return string?.replace("[^0-9]".toRegex(), "")
    }

    fun getMaxSpaceAvailableAtBottom(parentView: View, anchorView: View, topOffset: Int): Int {
        val rect = Rect()
        anchorView.getGlobalVisibleRect(rect)
        val parentRect = Rect()
        parentView.getGlobalVisibleRect(parentRect)
        return parentRect.bottom - rect.bottom - topOffset
    }

    fun getMaxSpaceAvailableAtTop(parentView: View, anchorView: View): Int {
        val rect = Rect()
        anchorView.getGlobalVisibleRect(rect)
        val parentRect = Rect()
        parentView.getGlobalVisibleRect(parentRect)
        return rect.top - parentRect.top
    }
}
