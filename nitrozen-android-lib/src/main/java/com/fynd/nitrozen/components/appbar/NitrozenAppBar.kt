package com.fynd.nitrozen.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun NitrozenAppBarPreview_Title() {
    NitrozenTheme {
        NitrozenAppBar(
            title = "Account"
        )
    }
}

@Preview
@Composable
private fun NitrozenAppBarPreview_LeadingTitle() {
    NitrozenTheme {
        NitrozenAppBar(
            title = "Account",
            leading = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = NitrozenTheme.colors.background
                    )
                }
            },
        )
    }
}

@Preview
@Composable
private fun NitrozenAppBarPreview_TitleTrailing() {
    NitrozenTheme {
        NitrozenAppBar(
            title = "Account",
            trailing = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = NitrozenTheme.colors.background
                    )
                }
            }
        )
    }
}

@Preview
@Composable
private fun NitrozenAppBarPreview_LeadingTitleTrailing() {
    NitrozenTheme {
        NitrozenAppBar(
            title = "Account",
            trailing = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = NitrozenTheme.colors.background
                    )
                }
            },
            leading = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = NitrozenTheme.colors.background
                    )
                }
            },
        )
    }
}

@Composable
fun NitrozenAppBar(
    modifier: Modifier = Modifier,
    title: String,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (RowScope.() -> Unit)? = null,
    style: NitrozenAppBarStyle = NitrozenAppBarStyle.Default,
    configuration: NitrozenAppBarConfiguration = NitrozenAppBarConfiguration.Default,
) {
    val titleStartPadding = if (leading != null)
            configuration.titleWithLeadingStartPadding
        else
            configuration.titleStartPadding

    Row(
        modifier = modifier
            .heightIn(min = configuration.minHeight)
            .fillMaxWidth()
            .background(style.backgroundColor),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leading != null) {
            Spacer(modifier = Modifier.width(configuration.leadingStartPadding))
            leading()
        }

        if (title.trim().isNotBlank()) {
            Text(
                text = title.trim(),
                style = style.titleTextStyle,
                color = style.titleTextColor,
                modifier = Modifier
                    .padding(horizontal = titleStartPadding)
                    .weight(1F),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (trailing != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                trailing()
            }
            Spacer(modifier = Modifier.width(configuration.trailingEndPadding))
        }
    }
}
