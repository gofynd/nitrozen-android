package com.fynd.nitrozen.utils.tooltip

import android.graphics.Matrix
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

object TipShape {
    val tipShapeTop: Shape = object: Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val baseWidth = 24f
            val baseHeight = 8f

            val path = Path().apply {
                moveTo(9.5756f, 6.8766f)
                lineTo(5.8529f, 2.7121f)
                cubicTo(4.3006f, 0.9756f, 2.1953f, 0f, 0f, 0f)
                lineTo(24f, 0f)
                cubicTo(21.8047f, 0f, 19.6994f, 0.9756f, 18.1471f, 2.7121f)
                lineTo(14.4244f, 6.8766f)
                cubicTo(13.0854f, 8.3745f, 10.9146f, 8.3745f, 9.5756f, 6.8766f)
                close()
            }

            return Outline.Generic(
                path
                    .asAndroidPath()
                    .apply {
                        transform(Matrix().apply {
                            setScale(size.width / baseWidth, size.height / baseHeight)
                        })
                    }
                    .asComposePath()
            )
        }
    }

    val tipShapeStart: Shape = object: Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val baseWidth = 8f
            val baseHeight = 24f

            val path = Path().apply {
                moveTo(6.8766f, 14.4244f)
                lineTo(2.7121f, 18.1471f)
                cubicTo(0.9756f, 19.6994f, 0f, 21.8047f, 0f, 24f)
                lineTo(0f, 0f)
                cubicTo(0f, 2.1953f, 0.9756f, 4.3006f, 2.7121f, 5.8529f)
                lineTo(6.8766f, 9.5756f)
                cubicTo(8.3745f, 10.9146f, 8.3745f, 13.0854f, 6.8766f, 14.4244f)
                close()
            }

            return Outline.Generic(
                path
                    .asAndroidPath()
                    .apply {
                        transform(Matrix().apply {
                            setScale(size.width / baseWidth, size.height / baseHeight)
                        })
                    }
                    .asComposePath()
            )
        }
    }


    val tipShapeEnd: Shape = object: Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val baseWidth = 8f
            val baseHeight = 24f

            val path = Path().apply {
                moveTo(1.1234f, 9.5756f)
                lineTo(5.2879f, 5.8529f)
                cubicTo(7.0244f, 4.3006f, 8f, 2.1953f, 8f, 0f)
                lineTo(8f, 24f)
                cubicTo(8f, 21.8047f, 7.0244f, 19.6994f, 5.2879f, 18.1471f)
                lineTo(1.1234f, 14.4244f)
                cubicTo(-0.3745f, 13.0854f, -0.3745f, 10.9146f, 1.1234f, 9.5756f)
                close()
            }

            return Outline.Generic(
                path
                    .asAndroidPath()
                    .apply {
                        transform(Matrix().apply {
                            setScale(size.width / baseWidth, size.height / baseHeight)
                        })
                    }
                    .asComposePath()
            )
        }
    }


    val tipShapeBottom: Shape = object: Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            val baseWidth = 24f
            val baseHeight = 8f

            val path = Path().apply {
                moveTo(14.4244f, 1.1234f)
                lineTo(18.1471f, 5.2879f)
                cubicTo(19.6994f, 7.0244f, 21.8047f, 8f, 24f, 8f)
                lineTo(0f, 8f)
                cubicTo(2.1953f, 8f, 4.3006f, 7.0244f, 5.8529f, 5.2879f)
                lineTo(9.5756f, 1.1234f)
                cubicTo(10.9146f, -0.3745f, 13.0854f, -0.3745f, 14.4244f, 1.1234f)
                close()
            }

            return Outline.Generic(
                path
                    .asAndroidPath()
                    .apply {
                        transform(Matrix().apply {
                            setScale(size.width / baseWidth, size.height / baseHeight)
                        })
                    }
                    .asComposePath()
            )
        }
    }
}