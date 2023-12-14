package com.fynd.nitrozen.components.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.R

@Preview
@Composable
private fun NitrozenBottomNavigation() {
    NitrozenTheme {
        NitrozenBottomNavigation(
            items = listOf(
                BottomNavItem(
                    1, R.string.nit_bottom_nav_item_title,
                    R.drawable.ic_nit_home,
                    BottomNavItem.BadgeConfiguration.Enabled(2)
                ),
                BottomNavItem(2, R.string.nit_bottom_nav_item_title, R.drawable.ic_nit_home),

            ),
            onClick = {},
            selectedItem = BottomNavItem(1, R.string.nit_bottom_nav_item_title, R.drawable.ic_nit_home),
        )
    }
}

@Composable
fun NitrozenBottomNavigation(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    onClick: (BottomNavItem) -> Unit,
    selectedItem: BottomNavItem? = null,
    style: NitrozenBottomNavigationStyle = NitrozenBottomNavigationStyle.Default,
    configuration: NitrozenBottomNavigationConfiguration = NitrozenBottomNavigationConfiguration.Default,
) {
    Column(
        modifier = modifier,
    ) {
        Divider(
            color = NitrozenTheme.colors.shadow,
        )
        BottomNavigation(
            backgroundColor = NitrozenTheme.colors.background,
            elevation = configuration.elevation,
        ) {
            for (item in items) {
                val itemSelected = item.id == selectedItem?.id
                NitrozenBottomNavigationItem(
                    item = item,
                    selected = itemSelected,
                    style = style,
                    onClick = { if (!itemSelected) onClick(item) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.NitrozenBottomNavigationItem(
    item: BottomNavItem,
    selected: Boolean,
    style: NitrozenBottomNavigationStyle,
    onClick: () -> Unit,
) {
    val iconTint = if (selected)
        style.selectedIconTint
    else
        style.unselectedIconTint

    val textColor = if (selected)
        style.selectedTextColor
    else
        style.unselectedTextColor

    BottomNavigationItem(
        icon = {
            if (item.badgeConfiguration is BottomNavItem.BadgeConfiguration.Enabled){
                BadgedBox(
                    badge = {
                        Badge(
                            backgroundColor = NitrozenTheme.colors.error50,
                            contentColor = NitrozenTheme.colors.background
                        ) {
                            val countText = if(item.badgeConfiguration.badgeCount > 9){
                                "9+"
                            }else{
                                item.badgeConfiguration.badgeCount.toString()
                            }
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                text = countText,
                                style = NitrozenTheme.typography.bodyXxsReg,
                                color = NitrozenTheme.colors.background,
                            )
                        }
                    }
                ){
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title),
                        tint = iconTint,
                    )
                }
            }else {
                Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = stringResource(id = item.title),
                    tint = iconTint,
                )
            }
        },
        label = {
            Text(
                text = stringResource(id = item.title),
                color = textColor,
                style = style.textStyle,
            )
        },
        selected = selected,
        onClick = onClick,
    )
}
