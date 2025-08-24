package com.storeforminecraft.app.feature.studio

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.component.AlertMessage
import com.storeforminecraft.app.core.designsystem.component.SFOMButton
import com.storeforminecraft.app.core.designsystem.component.SFOMButtonStyle
import com.storeforminecraft.app.core.designsystem.component.SFOMCheckbox
import com.storeforminecraft.app.core.designsystem.component.SFOMLabelInput
import com.storeforminecraft.app.core.designsystem.component.SFOMLabelInputStyle
import com.storeforminecraft.app.core.designsystem.component.SFOMSelect
import com.storeforminecraft.app.core.designsystem.icon.SFOMIcons
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme
import com.storeforminecraft.app.core.ui.ImageSelectionGallery


@Preview
@Composable
fun GameResourceUploadContentInfoScreenPreview() {
    SFOMTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = SFOMTheme.colorScheme.backgroundPrimary)
        ) {
            GameResourceUploadContentInfoScreen()
        }
    }
}

@Composable
fun GameResourceUploadContentInfoScreen() {
    val titleTextFieldState = rememberTextFieldState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(SFOMIcons.CLOSE),
                    contentDescription = null,
                    tint = SFOMTheme.colorScheme.textQuaternary
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Shall we upload\nnew content?",
                style = SFOMTheme.typography.XL.copy(fontWeight = FontWeight.Bold),
                color = SFOMTheme.colorScheme.textPrimary
            )

            Spacer(Modifier.height(24.dp))

            SFOMSelect(
                "Attached file",
                "Select",
                Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = SFOMTheme.colorScheme.outlineSecondary,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                SFOMButton(
                    text = "Change attached file",
                    icon = SFOMIcons.FOLDER,
                    iconTintColor = SFOMTheme.colorScheme.textPrimary,
                    backgroundColor = SFOMTheme.colorScheme.backgroundSecondary,
                    textColor = SFOMTheme.colorScheme.textPrimary,
                    sfomButtonStyle = SFOMButtonStyle.MD
                ) {

                }
            }

            Spacer(Modifier.height(12.dp))

            Row(Modifier.fillMaxWidth()) {
                SFOMSelect(
                    title = "Category",
                    hint = "Select",
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .border(
                            width = 0.5.dp,
                            color = SFOMTheme.colorScheme.outlineSecondary,
                            shape = RoundedCornerShape(16.dp, 0.dp, 0.dp, 16.dp)
                        )
                )

                SFOMSelect(
                    title = "Sub Category",
                    hint = "Select",
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .offset(x = (-0.5).dp)
                        .border(
                            width = 0.5.dp,
                            color = SFOMTheme.colorScheme.outlineSecondary,
                            shape = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp)
                        )
                )
            }

            Spacer(Modifier.height(12.dp))

            SFOMLabelInput(
                titleTextFieldState,
                Modifier.fillMaxWidth(),
                "Please enter a title",
                "Title",
                SFOMLabelInputStyle.Regular
            )
        }

        SFOMButton(
            "Next step",
            null,
            null,
            SFOMTheme.colorScheme.sfomGreenPrimary,
            SFOMTheme.colorScheme.textWhite,
            SFOMButtonStyle.FULLWIDTH
        ) {

        }
    }
}

@Preview
@Composable
fun GameResourceUploadAdditionalInfoScreenPreview() {
    SFOMTheme {
        GameResourceUploadAdditionalInfoScreen()
    }
}

@Composable
fun GameResourceUploadAdditionalInfoScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterStart),
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(SFOMIcons.ARROW_BACK),
                    contentDescription = null,
                    tint = SFOMTheme.colorScheme.textQuaternary
                )
            }

            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd),
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(SFOMIcons.CLOSE),
                    contentDescription = null,
                    tint = SFOMTheme.colorScheme.textQuaternary
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Write information\nabout your content.",
            style = SFOMTheme.typography.XL.copy(fontWeight = FontWeight.Bold),
            color = SFOMTheme.colorScheme.textPrimary
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "Preview images", style = SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = SFOMTheme.colorScheme.textPrimary
        )

        Spacer(Modifier.height(16.dp))

        ImageSelectionGallery(
            Modifier
                .fillMaxWidth()
                .offset(x = (-16).dp)
        )

        Spacer(Modifier.height(16.dp))

        AlertMessage(
            icon = SFOMIcons.INFO,
            iconTintColor = SFOMTheme.colorScheme.sfomBluePrimary,
            message = "Choose at least two screenshots that clearly show the features of your map.",
            messageTextColor = SFOMTheme.colorScheme.textPrimary,
            backgroundColor = SFOMTheme.colorScheme.sfomBlue100,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(32.dp))

        Text(
            text = "Did you use external resources?", style = SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = SFOMTheme.colorScheme.textPrimary
        )

        Spacer(Modifier.height(16.dp))

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            SFOMCheckbox(false) {

            }

            Spacer(Modifier.width(16.dp))

            Text(
                "Contains resources I didn't create.", style = SFOMTheme.typography.XS.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
                color = SFOMTheme.colorScheme.textSecondary
            )
        }

        Spacer(Modifier.height(16.dp))

        AlertMessage(
            icon = SFOMIcons.ERROR,
            iconTintColor = SFOMTheme.colorScheme.colorsExclamation,
            message = "If a copyright infringement claim is filed for content without a source, the content may be immediately subject to penalties.",
            messageTextColor = SFOMTheme.colorScheme.textPrimary,
            backgroundColor = Color(0xffFFF2C5),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(24.dp))

        Text(
            "Content Description", style = SFOMTheme.typography.MD.copy(
                fontWeight = FontWeight.SemiBold
            ), color = SFOMTheme.colorScheme.textPrimary
        )

        Spacer(Modifier.height(16.dp))

    }
}