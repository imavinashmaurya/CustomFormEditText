package com.avinash.formedittextview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputLayout

/**
 * Custom view for edit text for forms
 */
class CustomFormEditText : ConstraintLayout {

    private var mRootView: View? = null
    private var mInputTextLayout: TextInputLayout? = null
    private var mInputTextEditText: EditText? = null
    private var mCardView: CardView? = null
    private var mTvError: TextView? = null
    private var mProgress: ProgressBar? = null
    private var mIvAction: ImageView? = null
    private var mllError: LinearLayout? = null
    private var hint: String? = null
    private var mContext: Context? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context)
    }

    private fun init(context: Context) {
        initUI(context)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        initUI(context)
        //read xml attributes

        //read xml attributes
        val ta =
            context.theme.obtainStyledAttributes(attrs, R.styleable.CustomFormEditText, 0, 0)

        val hintAppearance: Int =
            ta.getResourceId(R.styleable.CustomFormEditText_customHintTextStyle, -1)
        if (hintAppearance != -1) {
            setHintStyle(hintAppearance)
        }

        val hint = ta.getString(R.styleable.CustomFormEditText_hint)
        if (hint != null) {
            setHint(hint)
        }

    }

    fun setHintStyle(hintAppearance: Int) {
        mInputTextLayout?.setHintTextAppearance(hintAppearance)
    }

    fun getEditText(): EditText? {
        return mInputTextEditText
    }

    fun getInputText(): TextInputLayout? {
        return mInputTextLayout
    }

    private fun initUI(context: Context) {
        mContext = context
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mRootView = inflater.inflate(R.layout.custom_form_edit_text, this)
        mCardView = mRootView?.findViewById(R.id.cardView)
        mInputTextLayout = mRootView?.findViewById(R.id.tilForm)
        mInputTextEditText = mRootView?.findViewById(R.id.editText)
        mIvAction = mRootView?.findViewById(R.id.ivAction)
        mProgress = mRootView?.findViewById(R.id.pbForm)
        mllError = mRootView?.findViewById(R.id.llError)
        mTvError = mRootView?.findViewById(R.id.tvError)
    }

    /**
     * Sets the {@link android.text.InputType} bits of this node.
     *
     * @param inputType inputType bits as defined by {@link android.text.InputType}.
     */
    fun setInputType(inputType: Int) {
        mInputTextEditText?.inputType = inputType
    }

    fun setError(error: String) {
        mllError?.visibility = View.VISIBLE
        mTvError?.text = error
    }

    fun clearError() {
        mllError?.visibility = View.GONE
        mTvError?.text = ""
    }

    fun showCompleteStatus() {
        mProgress?.visibility = View.GONE
        mIvAction?.visibility = View.VISIBLE
    }

    fun clearCompleteStatus() {
        mIvAction?.visibility = View.GONE
    }

    fun setActionIcon(icon: Int) {
        mIvAction?.setImageResource(icon)
        showCompleteStatus()
    }

    fun enableProgress() {
        clearCompleteStatus()
        mProgress?.visibility = View.VISIBLE
    }

    fun clearProgress() {
        mProgress?.visibility = View.GONE
    }

    fun setHint(hint: String) {
        mInputTextLayout?.hint = hint
    }

}