package com.storeforminecraft.app.feature.studio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.storeforminecraft.app.core.designsystem.component.TagStyleText
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.common.util.DateFormatType
import com.storeforminecraft.app.core.common.util.format
import com.storeforminecraft.app.core.designsystem.theme.SFOMColorScheme
import com.storeforminecraft.app.core.designsystem.theme.SFOMTypography
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.TextStyle

@Preview
@Composable
fun StudioTitleBarPreview() {
    SFOMTheme {
        StudioTopBar()
    }
}

@Composable
fun StudioTopBar() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.size(20.4.dp),
            painter = painterResource(SFOMIcons.ACCOUNT_CIRCLE),
            contentDescription = null
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = "Nickname", style = SFOMTheme.typography.XL.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.width(8.dp))

        Box(
            Modifier
                .size(20.dp)
                .background(
                    shape = CircleShape, color = SFOMTheme.colorScheme.sfomBlue500
                ), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "0",
                color = SFOMTheme.colorScheme.textReverse,
                style = SFOMTheme.typography.XS.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        }

        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        IconButton(modifier = Modifier.size(24.dp), onClick = {}) {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(SFOMIcons.SEARCH),
                contentDescription = null
            )
        }

        Spacer(Modifier.width(16.dp))

        IconButton(modifier = Modifier.size(24.dp), onClick = {

        }) {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(SFOMIcons.SETTINGS),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun StudioResourceItemPreview() {
    SFOMTheme {
        StudioResourceItem(Modifier, "제목", LocalDateTime.now(), 50, 50)
    }
}

@Composable
fun StudioResourceItem(
    modifier: Modifier,
    title: String,
    date: LocalDateTime,
    likesCount: Long,
    commentsCount: Long
) {
    Column(modifier) {
        Row {
            Box(
                Modifier
                    .size(103.dp)
                    .background(color = Color(0xfff2f2f2), shape = RoundedCornerShape(16.dp))
            )

            Spacer(Modifier.width(16.dp))

            Column(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Row(Modifier.fillMaxWidth()) {
                    TagStyleText(
                        text = "pending",
                        icon = SFOMIcons.SCHEDULE,
                        backgroundColor = SFOMTheme.colorScheme.backgroundSecondary,
                        textColor = SFOMTheme.colorScheme.textPrimary,
                        iconColor = SFOMTheme.colorScheme.colorsExclamation
                    )
                    Spacer(Modifier.width(8.dp))
                    TagStyleText(
                        text = "category",
                        icon = SFOMIcons.CATEGORY_MAP,
                        backgroundColor = SFOMTheme.colorScheme.mapSecondary,
                        textColor = SFOMTheme.colorScheme.textPrimary,
                        iconColor = SFOMTheme.colorScheme.mapPrimary
                    )
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    title,
                    color = SFOMTheme.colorScheme.textPrimary,
                    style = SFOMTheme.typography.MD.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = date.format(DateFormatType.YYYY_MM_DD),
                    color = SFOMTheme.colorScheme.textTertiary,
                    style = SFOMTheme.typography.MD.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(SFOMIcons.THUMB_UP_SMALL),
                null,
                Modifier.size(width = 11.17.dp, height = 9.69.dp),
                colorFilter = ColorFilter.tint(SFOMTheme.colorScheme.textTertiary)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = likesCount.toString(), style = SFOMTheme.typography.MD.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = SFOMTheme.colorScheme.textTertiary
                )
            )
            Spacer(Modifier.width(16.dp))
            Image(
                painterResource(SFOMIcons.COMMENT_SMALL),
                null,
                Modifier.size(10.dp),
                colorFilter = ColorFilter.tint(SFOMTheme.colorScheme.textTertiary)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = commentsCount.toString(), style = SFOMTheme.typography.MD.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = SFOMTheme.colorScheme.textTertiary
                )
            )
        }
    }
}