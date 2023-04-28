package com.nitrozen.android.ui.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.avatar.NitrozenNameAvatar
import com.fynd.nitrozen.components.avatar.NitrozenIconAvatar
import com.fynd.nitrozen.components.avatar.NitrozenPictureAvatar
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar
import com.nitrozen.android.R

@Preview
@Composable
private fun PreviewAvatarScreen() {
    NitrozenTheme {
        AvatarScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun AvatarScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Avatar",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Initials",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenNameAvatar(
                modifier = Modifier
                    .padding(top = 16.dp),
                name = "Test Avatar"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Picture",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenPictureAvatar(
                modifier = Modifier
                    .padding(top = 16.dp),
            ){
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.cat),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Icon",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenIconAvatar(
                modifier = Modifier
                    .padding(top = 16.dp),
            ){
                Icon(
                    modifier = Modifier
                        .size(32.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}