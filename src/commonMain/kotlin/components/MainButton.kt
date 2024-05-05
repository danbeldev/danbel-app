package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import primaryText
import tintColor

@Composable
fun MainButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = AbsoluteRoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = tintColor
        ),
        border = BorderStroke(2.dp, tintColor)
    ) {
        Text(text = text, color = primaryText)
    }
}