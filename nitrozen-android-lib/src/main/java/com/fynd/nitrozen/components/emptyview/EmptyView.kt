package com.fynd.nitrozen.components.emptyview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.components.common.DataStateView
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun EmptyViewPreview() {
    NitrozenTheme {
        NitrozenEmptyView(
            title = "Title",
            subtitle = "Sub Title"
        )
    }
}

/**
 * A composable function that displays a Nitrozen Empty View.
 * @param modifier optional [Modifier] to apply to the composable
 * @param topContent a lambda function which defines the composable content to be displayed at the top of the empty view, defaults to an image with id [R.drawable.empty_list]
 * @param bottomContent a nullable lambda function which defines the composable content to be displayed at the bottom of the empty view
 * @param title a String value indicating the title of the empty view
 * @param subtitle a nullable String value indicating the subtitle of the empty view
 * @param style an enum value indicating the style of the empty view, defaults to [NitrozenEmptyViewStyle.Companion.Default]
 * */
@Composable
fun NitrozenEmptyView(
    modifier : Modifier = Modifier,
    topContent : @Composable (ColumnScope) -> Unit = {
          Image(
              modifier = Modifier,
              painter = painterResource(id = R.drawable.empty_list),
              contentDescription = null
          )
        Spacer(modifier = Modifier.height(8.dp))
    },
    bottomContent : @Composable ((ColumnScope)->Unit)? = null,
    title : String,
    subtitle : String? = null,
    style: NitrozenEmptyViewStyle = NitrozenEmptyViewStyle.Default
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