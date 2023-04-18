package com.fynd.nitrozen.components.errorview

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.components.common.DataStateView
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun ErrorViewPreview() {
    NitrozenTheme {
        NitrozenErrorView(
            title = "No internet connection",
            subtitle = "Something went wrong while connecting to internet"
        )
    }
}

/**
 * A composable function that displays a Nitrozen Error View.
 * @param modifier optional [Modifier] to apply to the composable
 * @param topContent a nullable lambda function which defines the composable content to be displayed at the top of the error view
 * @param bottomContent a nullable lambda function which defines the composable content to be displayed at the bottom of the error view
 * @param title a String value indicating the title of the error view
 * @param subtitle a nullable String value indicating the subtitle of the error view
 * @param style an enum value indicating the style of the error view, defaults to [NitrozenErrorViewStyle.Companion.Default]
 *
 * */
@Composable
fun NitrozenErrorView(
    modifier : Modifier = Modifier,
    topContent : @Composable ((ColumnScope) -> Unit)? = null,
    bottomContent : @Composable ((ColumnScope)->Unit)? = null,
    title : String,
    subtitle : String? = null,
    style: NitrozenErrorViewStyle = NitrozenErrorViewStyle.Default
) {
    DataStateView(
        modifier = modifier,
        title = title,
        titleTextStyle = style.titleTextStyle,
        subTitle = subtitle,
        subTitleTextStyle = style.subTitleTextStyle,
        bottomContent = bottomContent,
        topContent = topContent
    )
}