package com.fynd.nitrozen.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun DataStatePreview() {
    NitrozenTheme {
        DataStateView(
            topContent = {  },
            title = "Title",
            titleTextStyle = NitrozenTheme.typography.bodySmall,
            subTitle = "Sub title",
            subTitleTextStyle = NitrozenTheme.typography.bodyXxsReg
        )
    }
}

@Composable
internal fun DataStateView(
    modifier : Modifier = Modifier,
    topContent : @Composable ((ColumnScope)->Unit)? = null,
    bottomContent : @Composable ((ColumnScope)->Unit)? = null,
    title : String,
    titleTextStyle: TextStyle,
    subTitle : String?,
    subTitleTextStyle: TextStyle,
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        topContent?.invoke(this)

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = titleTextStyle,
            textAlign = TextAlign.Center
        )

        subTitle?.let{
            Text(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                text = it,
                style = subTitleTextStyle,
                textAlign = TextAlign.Center
            )
        }

        bottomContent?.invoke(this)
    }
}