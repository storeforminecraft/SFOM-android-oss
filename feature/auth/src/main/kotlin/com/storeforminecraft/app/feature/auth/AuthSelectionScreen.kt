import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.storeforminecraft.app.core.designsystem.component.SFOMButton
import com.storeforminecraft.app.core.designsystem.component.SFOMButtonStyle
import com.storeforminecraft.app.core.designsystem.theme.SFOMTheme
import com.storeforminecraft.app.core.designsystem.theme.SFOMTypography

@Preview
@Composable
fun AuthSelectionScreenPreview() {
    SFOMTheme {
        AuthSelectionScreen()
    }
}

@Composable
fun AuthSelectionScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = SFOMTheme.colorScheme.backgroundPrimary)
            .padding(16.dp, 48.dp)
    ) {
        Text(
            "우주 최고의\n마인크래프트 콘텐츠 스토어", style = SFOMTheme.typography.XL.copy(
                color = SFOMTheme.colorScheme.textPrimary,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "마인크래프트를 즐겁게 하는 방법.\n새로운 시작.", style = SFOMTheme.typography.SM.copy(
                color = SFOMTheme.colorScheme.textPrimary,
                fontWeight = FontWeight.Normal
            )
        )
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
        )
        SFOMButton(
            text = "기존 계정으로 로그인",
            backgroundColor = SFOMTheme.colorScheme.backgroundPrimary,
            textColor = SFOMTheme.colorScheme.textPrimary,
            sfomButtonStyle = SFOMButtonStyle.FULLWIDTH,
            border = BorderStroke(0.5.dp, SFOMTheme.colorScheme.outlineSecondary)
        ) {

        }

        Spacer(Modifier.height(12.dp))

        SFOMButton(
            text = "SFOM 회원가입",
            backgroundColor = SFOMTheme.colorScheme.sfomGreenPrimary,
            textColor = SFOMTheme.colorScheme.textWhite,
            sfomButtonStyle = SFOMButtonStyle.FULLWIDTH
        ) {

        }
    }
}