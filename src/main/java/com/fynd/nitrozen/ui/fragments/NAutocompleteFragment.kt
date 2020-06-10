package com.fynd.nitrozen.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenautocomplete.NAutocomplete

class NAutocompleteFragment : Fragment() {

    lateinit var nAutocomplete: NAutocomplete
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_nautocomplete, container, false)
        nAutocomplete = root.findViewById(R.id.nAuto)
        val restaurants = arrayOf(
            "KFC",
            "Dominos",
            "Pizza Hut",
            "Burger King",
            "Subway",
            "Dunkin' Donuts",
            "Starbucks",
            "Cafe Coffee Day"
        )
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, restaurants)
        nAutocomplete.setAdapter(adapter)
        return root
    }
}
