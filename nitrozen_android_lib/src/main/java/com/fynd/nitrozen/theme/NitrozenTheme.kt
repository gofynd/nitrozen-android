
package com.fynd.nitrozen.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.theme.color.LocalNitrozenColors
import com.fynd.nitrozen.theme.color.NitrozenColors
import com.fynd.nitrozen.theme.radius.LocalNitrozenRadius
import com.fynd.nitrozen.theme.radius.NitrozenRadius
import com.fynd.nitrozen.theme.shape.LocalNitrozenShapes
import com.fynd.nitrozen.theme.shape.NitrozenShapes
import com.fynd.nitrozen.theme.typography.LocalNitrozenTypography
import com.fynd.nitrozen.theme.typography.NitrozenTypography

@Composable
fun NitrozenTheme(
    context: @Composable () -> Unit
) {
    val nitrozenColors = NitrozenColors(
        primary20 = colorResource(id = R.color.primary20),
        primary40 = colorResource(id = R.color.primary40),
        primary50 = colorResource(id = R.color.primary50),
        primary60 = colorResource(id = R.color.primary60),
        grey20 = colorResource(id = R.color.grey20),
        grey40 = colorResource(id = R.color.grey40),
        grey60 = colorResource(id = R.color.grey60),
        grey80 = colorResource(id = R.color.grey80),
        grey100 = colorResource(id = R.color.grey100),
        inverse = colorResource(id = R.color.inverse),
        error50 = colorResource(id = R.color.error50),
        error80 = colorResource(id = R.color.error80),
        success50 = colorResource(id = R.color.success50),
        success80 = colorResource(id = R.color.success80),
        background = colorResource(id = R.color.background),
        warning20 = colorResource(id = R.color.warning20),
        warning50 = colorResource(id = R.color.warning50),
        warning80 = colorResource(id = R.color.warning80),
    )

    val nitrozenTypography = NitrozenTypography(
        headingXs = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Black,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = (-0.3).sp
        ),
        headingXxs = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Black,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.3).sp
        ),
        bodyXsReg = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        ),
        bodyXsBold = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
            lineHeight = 20.sp,
        ),
        bodyXxsReg = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        ),
        bodyXsLink = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.5).sp
        ),
        bodySmall = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),
        bodySmallRegular = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        bodySmallBold = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
        ),
        bodyMediumBold = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        bodyLBold = NitrozenTypography.getDefault().copy(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
        )
    )

    val nitrozenRadius = NitrozenRadius(
        small = 4.dp,
        medium = 8.dp,
        large = 16.dp,
        xl = 24.dp,
        xxl = 32.dp,
        pill = 250.dp
    )

    val nitrozenShapes = NitrozenShapes(
        pill = RoundedCornerShape(nitrozenRadius.pill),
        topRoundedXl = RoundedCornerShape(
            topStart = nitrozenRadius.xl,
            topEnd = nitrozenRadius.xl
        ),
        roundedXl = RoundedCornerShape(nitrozenRadius.xl),
        rounded16 = RoundedCornerShape(nitrozenRadius.large),
        round = RoundedCornerShape(100)
    )

    CompositionLocalProvider(
        LocalNitrozenColors provides nitrozenColors,
        LocalNitrozenTypography provides nitrozenTypography,
        LocalNitrozenRadius provides nitrozenRadius,
        LocalNitrozenShapes provides nitrozenShapes,
        content = context
    )
}

object NitrozenTheme {
    val colors: NitrozenColors
        @Composable
        get() = LocalNitrozenColors.current

    val typography: NitrozenTypography
        @Composable
        get() = LocalNitrozenTypography.current

    val radius: NitrozenRadius
        @Composable
        get() = LocalNitrozenRadius.current

    val shapes: NitrozenShapes
        @Composable
        get() = LocalNitrozenShapes.current
}
