package com.bhi.commonlib.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.bhi.commonlib.R
import kotlinx.android.synthetic.main.layout_placeholder_view.view.*


/**
 * @author Rahul Rastogi
 *
 * This class shows a placeholder UI and hides associated content view on screens wherever data loading fails.
 * This placeholder can be shown in cases: during data loading, data loading success, data loading failure, no data found.
 *
 * Placeholder message and error drawable can be configured by user.
 */
open class PlaceholderView : FrameLayout {

    companion object {
        const val ACTION_MESSAGE_PLACEHOLDER = "{{action_icon}}"

        const val STATE_SUCCESS = 1
        const val STATE_FAIL = 2
        const val STATE_LOADING = 3
        const val STATE_NO_DATA_FOUND = 4
    }

    var onDescriptionClickListener: (() -> Unit)? = null
    private lateinit var placeholderContainerView: View
    private lateinit var contentView: View

    private var placeholderBackgroundRes: Int = 0
    var placeholderBackgroundColor: Int = 0
    var placeholderBackgroundDrawable: Drawable? = null
    var placeholderTextColor: Int? = null
    var actionDrawableResId = 0
    var actionMessage: String? = null

    var message: String? = null
        /**
         * Sets the message on placeholder view.
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                tv_placeholder_view_title.text = value
            }
        }


    var actionSecondaryMessage: String? = null
        /**
         * Sets the description on placeholder view.
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                setDescription(tv_placeholder_view_description, value)
            }
        }

    var actionSecondaryTint = 0
        /**
         * Changes color of action drawable.
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                setDescription(tv_placeholder_view_description, actionSecondaryMessage)
            }
        }

    var errorDrawableRes: Int = 0
        set(value) {
            if (value != errorDrawableRes) {
                field = value

                if (this::contentView.isInitialized) {
                    placeholderContainerView.tv_placeholder_view_title.setCompoundDrawablesWithIntrinsicBounds(0, value, 0, 0)
                    refreshViewTint()
                }
            }
        }

    var tint: Int = 0
        /**
         * Tint changes the text color of message and icon color of PlaceholderView.
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                refreshViewTint()
            }
        }

    var actionDrawableTintMode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN
        /**
         * Sets tint mode for action drawable
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                setActionMessage()
            }
        }

    var actionDrawableTint = 0
        /**
         * Changes color of action drawable.
         */
        set(value) {
            field = value

            if (this::contentView.isInitialized) {
                setActionMessage()
            }
        }

    var currentState: Int = PlaceholderState.STATE_NO_DATA_FOUND
        /**
         * Changes the state of PlaceholderView programmatically.
         */
        set(value) {
            field = value

            //If content view has been added to placeholder view.
            if (this::contentView.isInitialized) {
                onStateChange(value)
            }
        }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initialize(context, attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context, attrs, defStyleAttr)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize(context, attrs, 0)
    }

    constructor(context: Context) : super(context) {
        initialize(context, null, 0)
    }

    private fun initialize(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PlaceholderView, defStyleAttr, 0)
        errorDrawableRes = typedArray.getResourceId(R.styleable.PlaceholderView_error_drawable, 0)
        actionDrawableResId = typedArray.getResourceId(R.styleable.PlaceholderView_placeholder_action_drawable, 0)
        actionDrawableTint = typedArray.getColor(R.styleable.PlaceholderView_placeholder_action_drawable_tint, 0)
        actionMessage = typedArray.getString(R.styleable.PlaceholderView_placeholder_action_message)
        actionSecondaryMessage = typedArray.getString(R.styleable.PlaceholderView_placeholder_action_secondary)
        actionSecondaryTint = typedArray.getColor(R.styleable.PlaceholderView_placeholder_action_secondary_tint, 0)
        val placeholderTextColorRes = typedArray.getResourceId(R.styleable.PlaceholderView_placeholder_text_color, 0)
        val placeholderTextSize = typedArray.getResourceId(R.styleable.PlaceholderView_placeholder_text_size, 0)
        placeholderBackgroundRes = typedArray.getResourceId(R.styleable.PlaceholderView_placeholder_background, 0)
        val placeholderPosition =
                typedArray.getString(R.styleable.PlaceholderView_placeholder_position)
        typedArray.recycle()

        placeholderContainerView = LayoutInflater.from(context).inflate(R.layout.layout_placeholder_view, this, false)
        when (placeholderPosition) {
            "top" ->
                (placeholderContainerView.layoutParams as LayoutParams).gravity =
                        Gravity.TOP or Gravity.CENTER_HORIZONTAL
            "center" ->
                (placeholderContainerView.layoutParams as LayoutParams).gravity =
                        Gravity.CENTER or Gravity.CENTER_HORIZONTAL
            "bottom" ->
                (placeholderContainerView.layoutParams as LayoutParams).gravity =
                        Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        }
        addView(placeholderContainerView)

        tv_placeholder_view_title.text = message

        if (placeholderTextColor != null) {
            tv_placeholder_view_title.setTextColor(placeholderTextColor!!)
            progress_bar_placeholder_view.indeterminateTintList = ColorStateList.valueOf(placeholderTextColor!!)

        } else if (placeholderTextColorRes != 0) {
            tv_placeholder_view_title.setTextColor(ContextCompat.getColor(context, placeholderTextColorRes))
            progress_bar_placeholder_view.indeterminateTintList = ColorStateList.valueOf(ContextCompat.getColor(context, placeholderTextColorRes))
        }

        if (placeholderTextSize != 0) {
            tv_placeholder_view_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(placeholderTextSize))
        }

        refreshViewTint()
    }

    override fun onViewAdded(child: View?) {
        super.onViewAdded(child)
        //When placeholder view's content view is being added to placeholder view.
        if (childCount == 2) {
            contentView = child!!
            onStateChange(currentState)
        } else if (childCount > 2) {
            throw IllegalStateException("PlaceholderView can host only one direct child.")
        }
    }

    fun onLoading(message: String = context.getString(R.string.msg_on_loading)) {
        currentState = STATE_LOADING
        this.message = message
    }

    fun onLoading(@StringRes stringResId: Int) {
        if (stringResId != 0) onLoading(context.getString(stringResId)) else onLoading()
    }

    fun onLoadingSuccess() {
        currentState = STATE_SUCCESS
    }

    fun onLoadingFail(message: String = context.getString(R.string.msg_on_loading_failed)) {
        currentState = STATE_FAIL
        this.message = message
    }

    fun onLoadingFail(@StringRes stringResId: Int) {
        if (stringResId != 0) onLoadingFail(context.getString(stringResId)) else onLoadingFail()
    }

    fun onNoDataFound(message: String = context.getString(R.string.msg_no_data_found)) {
        currentState = STATE_NO_DATA_FOUND
        this.message = message
    }

    fun onNoDataFound(@StringRes stringResId: Int) {
        if (stringResId != 0) onNoDataFound(context.getString(stringResId)) else onNoDataFound()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        setActionMessage()
    }

    private fun onStateChange(state: Int) {
        when (state) {
            STATE_LOADING -> {
                if (placeholderBackgroundRes != 0) {
                    setBackgroundResource(placeholderBackgroundRes)
                }

                progress_bar_placeholder_view.visibility = View.VISIBLE
                contentView.visibility = View.INVISIBLE
                placeholderContainerView.tv_placeholder_view_title.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                placeholderContainerView.visibility = View.VISIBLE
                tv_placeholder_view_action_message.visibility = View.GONE
            }
            STATE_FAIL -> {
                when {
                    placeholderBackgroundRes != 0 -> setBackgroundResource(placeholderBackgroundRes)
                    placeholderBackgroundColor != 0 -> setBackgroundColor(placeholderBackgroundColor)
                    null != placeholderBackgroundDrawable -> background = placeholderBackgroundDrawable
                }

                if (errorDrawableRes != 0) {
                    placeholderContainerView.tv_placeholder_view_title.setCompoundDrawablesWithIntrinsicBounds(0, errorDrawableRes, 0, 0)
                }

                progress_bar_placeholder_view.visibility = View.GONE
                contentView.visibility = View.INVISIBLE
                placeholderContainerView.visibility = View.VISIBLE
                tv_placeholder_view_action_message.visibility = View.GONE
            }
            STATE_NO_DATA_FOUND -> {
                when {
                    placeholderBackgroundRes != 0 -> setBackgroundResource(placeholderBackgroundRes)
                    placeholderBackgroundColor != 0 -> setBackgroundColor(placeholderBackgroundColor)
                    null != placeholderBackgroundDrawable -> background = placeholderBackgroundDrawable
                }

                if (errorDrawableRes != 0) {
                    placeholderContainerView.tv_placeholder_view_title.setCompoundDrawablesWithIntrinsicBounds(0, errorDrawableRes,
                            0, 0)
                }

                progress_bar_placeholder_view.visibility = View.GONE
                contentView.visibility = View.INVISIBLE
                placeholderContainerView.visibility = View.VISIBLE
            }
            STATE_SUCCESS -> {
                background = null

                progress_bar_placeholder_view.visibility = View.GONE
                contentView.visibility = View.VISIBLE
                placeholderContainerView.visibility = View.INVISIBLE
                tv_placeholder_view_action_message.visibility = View.GONE
            }
        }

        tv_placeholder_view_title.text = message
        setDescription(tv_placeholder_view_description, actionSecondaryMessage)

        setActionMessage()
        refreshViewTint()
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        if (hasWindowFocus && this::contentView.isInitialized) {
            setActionMessage()
        }
    }

    private fun refreshViewTint() {
        progress_bar_placeholder_view.indeterminateDrawable.setColorFilter(tint, PorterDuff.Mode.SRC_IN)
        tv_placeholder_view_title.setTextColor(tint)
        tv_placeholder_view_action_message.setTextColor(tint)

        tv_placeholder_view_title.compoundDrawablesRelative.forEach { drawable ->
            drawable?.colorFilter = PorterDuffColorFilter(tint, PorterDuff.Mode.SRC_IN)
        }

        tv_placeholder_view_title.compoundDrawables.forEach { drawable ->
            drawable?.colorFilter = PorterDuffColorFilter(tint, PorterDuff.Mode.SRC_IN)
        }
    }


    private fun setActionMessage() {
        if (TextUtils.isEmpty(actionMessage)) {
            tv_placeholder_view_action_message.visibility = View.GONE
            return
        }

        tv_placeholder_view_action_message.visibility = View.VISIBLE

        if (actionDrawableResId == 0) {
            tv_placeholder_view_action_message.text = actionMessage
        } else {
            val actionDrawableIndex = actionMessage!!.indexOf(ACTION_MESSAGE_PLACEHOLDER)
            val message = actionMessage!!.replace(ACTION_MESSAGE_PLACEHOLDER, "")

            val actionSpannableStringBuilder = SpannableStringBuilder(message)
            val actionImageSpan = VerticalImageSpan(context, actionDrawableResId)

            Handler(Looper.getMainLooper()).post {
                if (actionDrawableTint != 0) {
                    actionImageSpan.drawable.setTintMode(actionDrawableTintMode)
                    actionImageSpan.drawable.setTint(actionDrawableTint)
                }

                actionSpannableStringBuilder.setSpan(actionImageSpan, actionDrawableIndex, actionDrawableIndex + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                actionSpannableStringBuilder.insert(actionDrawableIndex + 1, " ")

                tv_placeholder_view_action_message.text = actionSpannableStringBuilder
            }
        }
    }

    fun setTitleTypeface(typeface: Int) {
        tv_placeholder_view_title.setTypeface(tv_placeholder_view_title.typeface, typeface)
    }

    private fun setDescription(textView: TextView, actionSecondaryMessage: String?) {
        textView.text = actionSecondaryMessage

        if (currentState == PlaceholderState.STATE_NO_DATA_FOUND && !TextUtils.isEmpty(actionSecondaryMessage)) {
            ll_placeholder_description.visibility = View.VISIBLE
            tv_placeholder_view_description.setTextColor(actionSecondaryTint)

            tv_placeholder_view_description.setOnClickListener { onDescriptionClickListener?.invoke() }
        } else {
            ll_placeholder_description.visibility = View.GONE
        }
    }

}
