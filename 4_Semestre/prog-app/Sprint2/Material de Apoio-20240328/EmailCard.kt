package NOME_DO_SEU_PACKAGE

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailCard(
    modifier: Modifier = Modifier,
    data: EmailModel = EmailModel.getMock()
) {
    Surface(
        color = Color.White,
        modifier = modifier.border(
            width = 1.dp, color = Utils.colorFromHexadecimal("#A01E1E1E")
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = data.initials.text,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        color = Utils.colorFromHexadecimal(data.initials.color),
                        shape = CircleShape
                    )
                    .wrapContentHeight(Alignment.CenterVertically)
                    .size(48.dp)
                    .padding(vertical = 14.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 4.dp)
            ) {
                Text(
                    fontSize = 12.sp,
                    text = data.subject
                )
                Text(text = data.body)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmailCardPreview() {
    NOME_DO_SEU_THEME {
        EmailCard()
    }
}