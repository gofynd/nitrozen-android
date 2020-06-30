package com.fynd.nitrozen.nitrozendropdown.drawer

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozendropdown.NDropdown
import com.fynd.nitrozen.nitrozendropdown.model.NitrozenDropdown
import com.fynd.nitrozen.nitrozendropdown.views.CustomSpinner
import com.fynd.nitrozen.nitrozenloader.NLoader
import com.fynd.nitrozen.utils.Drawer


class SpinnerDrawer(val view: NDropdown, val nDropdown: NitrozenDropdown) :
    Drawer<NDropdown, NitrozenDropdown>(view, nDropdown), CustomSpinner.OnSpinnerEventsListener {

    private var appCompatSpinner: CustomSpinner = CustomSpinner(
        view.context, null, android.R.style.Widget_Spinner,
        Spinner.MODE_DROPDOWN
    )
    private var imgDropDown: AppCompatImageView = AppCompatImageView(view.context)
    private var tvPlaceHolder: TextView = TextView(view.context)
    private var rootLayout: RelativeLayout = RelativeLayout(view.context)
    private val DROPDOWN_LIST_TAG = "DROPDOWN_LIST"

    override fun draw() {
        if (isReady()) {
            isViewAdded = true
            appCompatSpinner.background = null
            tvPlaceHolder.includeFontPadding = false
            try {
                val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
                tvPlaceHolder.setTypeface(tf, Typeface.NORMAL)
            } catch (e: Exception) {
            }
            init()
            val rootParams: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    addRule(RelativeLayout.CENTER_VERTICAL)
                }
            val spinnerParams: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
            val imageParams: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(
                    dpToPx(14f).toInt(),
                    dpToPx(24f).toInt()
                )
            imageParams.setMargins(0, 0, dpToPx(8f).toInt(), 0)
            imageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            imageParams.addRule(RelativeLayout.CENTER_VERTICAL)
            appCompatSpinner.layoutParams = spinnerParams
            appCompatSpinner.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    android.R.color.transparent
                )
            )
            appCompatSpinner.setSpinnerEventsListener(this)
            appCompatSpinner.minimumHeight = dpToPx(40f).toInt()
            appCompatSpinner.setPopupBackgroundResource(R.drawable.ndropdown_list_background)
            imgDropDown.layoutParams = imageParams
            imgDropDown.setImageResource(R.drawable.ic_ndropdown)
            rootLayout.layoutParams = rootParams

            val params: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
            params.setMargins(dpToPx(10f).toInt(), 0, dpToPx(30f).toInt(), 0)
            params.addRule(RelativeLayout.CENTER_VERTICAL)
            tvPlaceHolder.layoutParams = params


            nDropdown.spinner = appCompatSpinner
            rootLayout.addView(tvPlaceHolder)
            rootLayout.addView(appCompatSpinner)
            rootLayout.addView(imgDropDown)
            rootLayout.isClickable = true
            view.addView(rootLayout)
            if (nDropdown.showLoader) {
                val v = View.inflate(view.context, R.layout.ndropdown_loader, null)
                v.tag = DROPDOWN_LIST_TAG
                val loaderParams: RelativeLayout.LayoutParams =
                    RelativeLayout.LayoutParams(
                        nDropdown.layoutWidth,
                        nDropdown.layoutHeight
                    )
                v.layoutParams = loaderParams
                v.visibility = when {
                    nDropdown.isFocused -> {
                        View.VISIBLE
                    }
                    else -> {
                        View.GONE
                    }
                }
                view.addView(v)
            }
        }
    }

    fun setPlaceHolder() {
        tvPlaceHolder.text = nDropdown.placeHolder
        if (nDropdown.placeHolder.isNotEmpty() && appCompatSpinner.adapter == null) {
            tvPlaceHolder.visibility = View.VISIBLE
        } else {
            tvPlaceHolder.visibility = View.GONE
        }
    }

    override fun isReady(): Boolean {
        return true
    }

    private fun init() {
        if (nDropdown.showLoader) {
            appCompatSpinner.adapter = getBlankAdapter()
            if (nDropdown.isFocused) {
                val dropDownListView = getDropdownListView()
                if (dropDownListView != null) {
                    dropDownListView.visibility = View.VISIBLE
                }
                imgDropDown.rotation = 180f
                rootLayout.setBackgroundResource(R.drawable.ndropdown_selected_background)
            } else {
                val dropDownListView = getDropdownListView()
                if (dropDownListView != null) {
                    dropDownListView.visibility = View.GONE
                }
                imgDropDown.rotation = 0f
                rootLayout.setBackgroundResource(R.drawable.ndropdown_background)
            }
        } else {
            if (appCompatSpinner.adapter == null || appCompatSpinner.adapter.count == 0) {
                imgDropDown.rotation = 0f
                rootLayout.setBackgroundResource(R.drawable.ndropdown_background)
            } else {
                if (nDropdown.isFocused) {
                    imgDropDown.rotation = 180f
                    rootLayout.setBackgroundResource(R.drawable.ndropdown_selected_background)
                } else {
                    imgDropDown.rotation = 0f
                    rootLayout.setBackgroundResource(R.drawable.ndropdown_background)
                }
            }
        }

        setPlaceHolder()
        if (!nDropdown.enabled) {
            rootLayout.setBackgroundResource(R.drawable.disabled_background)
        } else if (!nDropdown.editable) {
            rootLayout.setBackgroundResource(R.drawable.uneditable_background)
        }
    }

    private fun getDropdownListView(): View? {
        for (i in 0 until view.childCount) {
            if (view.getChildAt(i).tag == DROPDOWN_LIST_TAG) {
                if (i == 1) {
                    return (view.getChildAt(1) as NLoader).apply {
                        setColor(R.color.nitrozen_seconday_color)
                    }
                }
                return view.getChildAt(i)
            }
        }
        return null
    }

    override fun updateLayout() {
        if (isViewAdded) {
            init()
        } else {
            draw()
        }
    }

    private fun getBlankAdapter(): ArrayAdapter<String> {
        return object : ArrayAdapter<String>(
            view.context,
            R.layout.ndropdown_blank_item, mutableListOf()
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View,
                parent: ViewGroup
            ): View {
                var v: View? = null
                if (position == 0) {
                    val tv = TextView(context)
                    tv.height = 0
                    tv.visibility = View.GONE
                    v = tv
                } else {
                    v = super.getDropDownView(position, null, parent)
                }
                parent.isVerticalScrollBarEnabled = false
                return v!!
            }
        }
    }

    override fun onSpinnerOpened() {
        nDropdown.isFocused = true
        init()
    }

    override fun onSpinnerClosed() {
        nDropdown.isFocused = false
        init()
    }
}