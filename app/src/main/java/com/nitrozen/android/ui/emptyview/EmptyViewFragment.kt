package com.nitrozen.android.ui.emptyview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.MainActivity
import com.nitrozen.android.navigator.Navigator

class EmptyViewFragment : Fragment() {

    private lateinit var navigator: Navigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = (requireActivity() as MainActivity).navigator
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                NitrozenTheme {
                    EmptyViewScreen(
                        onBackClick = { navigator.goBack() }
                    )
                }
            }
        }
    }
}