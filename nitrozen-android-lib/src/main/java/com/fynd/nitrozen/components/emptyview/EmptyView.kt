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
    emptyStyle: NitrozenEmptyViewStyle = NitrozenEmptyViewStyle.Default
) {
    DataStateView(
        modifier = modifier,
        title = title,
        titleTextStyle = emptyStyle.titleTextStyle,
        subTitle = subtitle,
        subTitleTextStyle = emptyStyle.subTitleTextStyle,
        bottomContent = bottomContent,
        topContent = topContent
    )
}