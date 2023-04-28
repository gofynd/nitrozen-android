package com.fynd.nitrozen.components.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.avatar.NitrozenAvatarConfiguration.Default
import com.fynd.nitrozen.components.avatar.NitrozenAvatarStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithRipple

@Preview
@Composable
private fun AvatarInitialsPreview() {
    NitrozenTheme {
        NitrozenNameAvatar(
            name = "Test Case"
        )
    }
}

@Preview
@Composable
private fun AvatarPicturePreview() {
    NitrozenTheme {
        NitrozenPictureAvatar(
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color.Green
                        )
                )
            }
        )
    }
}

@Preview
@Composable
private fun AvatarIconPreview() {
    NitrozenTheme {
        NitrozenIconAvatar() {
            Icon(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Default.Person,
                contentDescription = null,
            )
        }
    }
}


/**
 * A composable function that displays a Nitrozen Name Avatar.
 * @param modifier optional [Modifier] to apply to the composable
 * @param name the name to be displayed as initials in the avatar
 * @param enabled a boolean value indicating whether the avatar is enabled or not
 * @param onTap a function to be called when the avatar is tapped, can be null
 * @param style indicating the style of the initials avatar, defaults to [NitrozenAvatarStyle.Initials.Companion.Default]
 * @param configuration indicating the configuration of the initials avatar, defaults to [NitrozenAvatarConfiguration.Initials.Companion.Default]
 * */
@Composable
fun NitrozenNameAvatar(
    modifier: Modifier = Modifier,
    name : String,
    enabled : Boolean = true,
    onTap : (()->Unit)? = null,
    style: NitrozenAvatarStyle.Initials = NitrozenAvatarStyle.Initials.Default,
    configuration : NitrozenAvatarConfiguration.Initials = NitrozenAvatarConfiguration.Initials.Default
){
    val initials = getInitials(name = name)
    Box(
        modifier = modifier
            .alpha(
                if(enabled) 1f
                else 0.3f
            )
            .size(
                width = configuration.size.width,
                height = configuration.size.height
            )
            .clip(
                shape = style.shape
            )
            .background(
                color = style.backgroundColor,
                shape = style.shape
            )
            .then(
                if(enabled && onTap!=null){
                    Modifier.clickableWithRipple(onTap)
                }
                else Modifier
            )
            .padding(configuration.contentPadding),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = initials,
            style = style.textStyle,
            color = style.textColor
        )
    }
}

private fun getInitials(name: String): String{
    val list = name.trim().split(" ")
        .filter { it.isNotBlank() }
        .take(2)
    val initials = if (list.size == 1) {
        list.first().take(2)
    } else {
        list.joinToString("") { it.first().toString() }
    }.uppercase()

    return initials
}

/**
 * A composable function that displays a Nitrozen Picture Avatar.
 * @param modifier optional [Modifier] to apply to the composable
 * @param enabled a boolean value indicating whether the avatar is enabled or not
 * @param onTap a function to be called when the avatar is tapped, can be null
 * @param style indicating the style of the picture avatar, defaults to [NitrozenAvatarStyle.Picture.Companion.Default]
 * @param configuration indicating the configuration of the picture avatar, defaults to [NitrozenAvatarConfiguration.Picture.Companion.Default]
 * @param content a lambda function which defines the composable content to be displayed inside the avatar
 * */
@Composable
fun NitrozenPictureAvatar(
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    onTap : (()->Unit)? = null,
    style: NitrozenAvatarStyle.Picture = NitrozenAvatarStyle.Picture.Default,
    configuration: NitrozenAvatarConfiguration.Picture = NitrozenAvatarConfiguration.Picture.Default,
    content : @Composable () -> Unit,
){
    Box(
        modifier = modifier
            .alpha(
                if(enabled) 1f
                else 0.3f
            )
            .size(
                width = configuration.size.width,
                height = configuration.size.height
            )
            .clip(
                shape = style.shape
            )
            .background(
                color = Color.Unspecified,
                shape = style.shape
            )
            .then(
                if(enabled && onTap!=null){
                    Modifier.clickableWithRipple(onTap)
                }
                else Modifier
            ),
        contentAlignment = Alignment.Center
    ){
        content()
    }
}

/**
 * A composable function that displays a Nitrozen Icon Avatar.
 * @param modifier optional [Modifier] to apply to the composable
 * @param enabled a boolean value indicating whether the avatar is enabled or not
 * @param onTap a function to be called when the avatar is tapped, can be null
 * @param style indicating the style of the icon avatar, defaults to [NitrozenAvatarStyle.Icon.Companion.Default]
 * @param configuration indicating the configuration of the icon avatar, defaults to [NitrozenAvatarConfiguration.Icon.Companion.Default]
 * @param icon a lambda function which defines the composable content of the icon to be displayed inside the avatar
 * */
@Composable
fun NitrozenIconAvatar(
    modifier: Modifier = Modifier,
    enabled : Boolean = true,
    onTap : (()->Unit)? = null,
    style: NitrozenAvatarStyle.Icon = NitrozenAvatarStyle.Icon.Default,
    configuration: NitrozenAvatarConfiguration.Icon = NitrozenAvatarConfiguration.Icon.Default,
    icon : @Composable () -> Unit
){
    Box(
        modifier = modifier
            .alpha(
                if(enabled) 1f
                else 0.3f
            )
            .size(
                width = configuration.size.width,
                height = configuration.size.height
            )
            .clip(
                shape = style.shape
            )
            .background(
                color = style.backgroundColor,
                shape = style.shape
            )
            .then(
                if(enabled && onTap!=null){
                    Modifier.clickableWithRipple(onTap)
                }
                else Modifier
            )
            .padding(configuration.contentPadding),
        contentAlignment = Alignment.Center
    ){
        CompositionLocalProvider(LocalContentColor provides style.tint) {
            icon()
        }
    }
}

