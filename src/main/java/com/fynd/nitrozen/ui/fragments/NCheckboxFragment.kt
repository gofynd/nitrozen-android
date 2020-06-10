package com.fynd.nitrozen.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.fynd.nitrozen.R

class NCheckboxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_ncheckbox, container, false)

        return root
    }
}
