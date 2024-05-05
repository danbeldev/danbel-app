import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.MainButton
import data.GIT_HUB_PROJECT_URL
import data.allData
import kotlinx.coroutines.delay
import org.example.danbelapp.generated.resources.Res
import org.example.danbelapp.generated.resources.profile
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

val fontFamily = FontFamily.Serif

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    var visibility by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300L)
        visibility = true
    }

    MaterialTheme(
        colors = darkColors(
            primary = primaryBackground,
            secondary = secondaryBackground,
            onPrimary = primaryText,
            onSecondary = primaryText,
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(primaryBackground)
        ) {
            AnimatedVisibility(
                visible = visibility,
                enter = fadeIn(
                    initialAlpha = 0f,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutSlowInEasing
                    )
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(Res.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.size(125.dp).padding(15.dp)
                    )

                    Text(
                        text = "DanBel - Данила Беляков",
                        color = primaryText,
                        fontWeight = FontWeight.W900,
                        fontFamily = fontFamily,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(allData) { item ->
                            AnimatedContent(
                                targetState = item
                            ) { currentItem ->
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    ) {
                                        currentItem.icon?.let { icon ->
                                            Image(
                                                painter = painterResource(icon),
                                                contentDescription = null,
                                                modifier = Modifier.size(35.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                        }

                                        Text(
                                            text = currentItem.title,
                                            color = primaryText,
                                            fontFamily = fontFamily,
                                            fontWeight = FontWeight.W700,
                                            fontSize = 20.sp
                                        )
                                    }

                                    Divider(color = tintColor)

                                    LazyRow(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        items(currentItem.links) { linkData ->
                                            MainButton(
                                                text = linkData.text,
                                                modifier = Modifier.padding(8.dp),
                                                onClick = {
                                                    openLinkInBrowser(linkData.link)
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            TextButton(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd),
                onClick = {
                    openLinkInBrowser(GIT_HUB_PROJECT_URL)
                }
            ) {
                Text(
                    text = "Kotlin Multiplatform",
                    color = Color.White,
                    fontWeight = FontWeight.W200,
                )
            }
        }
    }
}