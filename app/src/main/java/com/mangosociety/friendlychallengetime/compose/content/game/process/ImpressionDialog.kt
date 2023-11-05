package com.mangosociety.friendlychallengetime.compose.content.game.process

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.mangosociety.friendlychallengetime.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BoxScope.ImpressionDialog() {

    var rate by remember {
        mutableIntStateOf(1)
    }

    var impression by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .align(Alignment.Center)
    ) {
        Text(
            text = "оцените задание:",
            color = Color(0xFFE9DFFC),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            for (item in 1..rate) {
                Image(
                    painter = painterResource(id = R.drawable.ic_rate_select_star),
                    contentDescription = "",
                    modifier = Modifier
                        .width(48.dp)
                        .height(40.dp)
                        .align(Alignment.CenterVertically)
                        .clickable { rate = item }
                )
            }

            if (rate < 5) {
                for (item in 1..(5 - rate)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_rate_inselect_star),
                        contentDescription = "",
                        modifier = Modifier
                            .width(48.dp)
                            .height(40.dp)
                            .align(Alignment.CenterVertically)
                            .clickable { rate += item }
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .heightIn(min = 200.dp)
                .background(
                    color = Color(0xFFF1EAFF),
                    shape = RoundedCornerShape(6.dp)
                )
        ) {

            TextField(
                value = impression,
                onValueChange = { data ->
                    impression = data
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedTextColor = Color(0xFF594888),
                    unfocusedTextColor = Color(0xFF594888),
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Transparent,
                    errorCursorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        text = "Оставьте впечатление ...",
                        fontSize = 16.sp,
                        color = Color(0xFF594888),
                    )
                },
//                fontSize = 16.sp,
//                color = Color(0xFF594888),
                modifier = Modifier
//                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
                    .align(Alignment.TopStart)
                    .padding(vertical = 4.dp)
                    .padding(start = 4.dp, end = 44.dp)
            )

            val context = LocalContext.current
            val file = context.createImageFile()
            val uri = FileProvider.getUriForFile(
                Objects.requireNonNull(context),
                "com.mangosociety.friendlychallengetime.provider", file
            )

            var capturedImageUri by remember {
                mutableStateOf<Uri>(Uri.EMPTY)
            }

            val cameraLauncher =
                rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
                    capturedImageUri = uri
                }

            val permissionLauncher = rememberLauncherForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {
                if (it) {
                    Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
                    cameraLauncher.launch(uri)
                } else {
                    Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_add_photo),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .clickable {
                        val permissionCheckResult =
                            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                            cameraLauncher.launch(uri)
                        } else {
                            permissionLauncher.launch(Manifest.permission.CAMERA)
                        }
                    }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                if (capturedImageUri.path?.isNotEmpty() == true) {
                    ImageShort(image = capturedImageUri)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 8.dp)

                ) {
                    Button(
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        enabled = true,
                        onClick = {
//                    component.onBackClicked()
                        }) {
                        Text(
                            "пропустить", color = Color(0x80594888),
                            fontSize = 16.sp
                        )
                    }

                    Button(
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE2D5F9)
                        ),
                        enabled = true,
                        shape = RoundedCornerShape(4.dp),
                        onClick = {
//                        onCompleteTask.invoke()
                        }) {
                        Text(
                            "готово", color = Color(0xFF594888),
                            fontSize = 16.sp
                        )
                    }
                }
            }


        }

        UnderlinedText(
            text = "пропустить на всю игру",
            color = Color(0xFFE9DFFC),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )

    }

}

@Composable
private fun ImageShort(image: Uri) {
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .width(52.dp)
            .height(52.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.FillWidth,
            painter = rememberImagePainter(image),
            contentDescription = null
        )

        Image(
            modifier = Modifier.size(12.dp).align(Alignment.TopEnd).clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_close_simple),
            contentDescription = ""
        )
    }
}

@Composable
fun UnderlinedText(text: String, color: Color, fontSize: TextUnit, modifier: Modifier = Modifier) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = color,
                fontSize = fontSize,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(text)
        }
    }

    Text(
        text = annotatedText,
        modifier = modifier
    )
}

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        externalCacheDir      /* directory */
    )
    return image
}