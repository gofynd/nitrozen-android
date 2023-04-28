package com.nitrozen.android.ui.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.components.bottomnavigation.BottomNavItem
import com.fynd.nitrozen.components.bottomnavigation.NitrozenBottomNavigation
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewBottomNavigationScreen() {
    NitrozenTheme {
        BottomNavigationScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun BottomNavigationScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "BottomNavigation",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Basic",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenBottomNavigation(
                items = listOf(
                    BottomNavItem(1, R.string.nit_bottom_nav_item_title, R.drawable.ic_nit_home),
                    BottomNavItem(2, R.string.nit_bottom_nav_item_title, R.drawable.ic_nit_home)
                ),
                onClick = {},
                selectedItem = BottomNavItem(1, R.string.nit_bottom_nav_item_title, R.drawable.ic_nit_home),
            )
        }

    }
}