package com.chebby.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun login(
    backgroundImageResId: Int = R.drawable.index1,
    content : @Composable () -> Unit ={}
) {
    val Login = LocalContext.current
    var username by remember{
        mutableStateOf(TextFieldValue(""))
    }
    var Password by remember{
        mutableStateOf(TextFieldValue(""))
    }
    Box(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(id = backgroundImageResId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        content()
    }
    LazyColumn(modifier = Modifier
        .fillMaxSize(),
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(
                    modifier = Modifier
                        .padding(20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.index),
                    contentDescription = null,
                    Modifier
                        .clip(CircleShape)
                        .border(5.dp, Color(0xffa87373), CircleShape)
                        .size(128.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Column(
                    modifier = Modifier
                        .padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "LOGIN",
                        Modifier,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 58.sp,
                        color = Color(0xfffafafa),
                        textAlign = TextAlign.Center,
                        )
                    Spacer(
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    TextField(value = username,
                        onValueChange = { username = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = "Enter Your Username")},
                    )
                    Spacer(
                            modifier = Modifier
                                .padding(5.dp)
                            )
                    TextField(value = Password,
                        onValueChange = { Password = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = "Enter Your Password")},
                        visualTransformation = PasswordVisualTransformation()
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Button(
                        onClick = {
                            Login.startActivity(Intent(Login, MainActivity::class.java))
                        },
                        shape = RoundedCornerShape(8.dp),
                        //shape = RectangleShape,

                    ) {
                        Text("Login")
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Text(text = "OR",
                            Modifier,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 24.sp,
                        color = Color(0xfffafafa),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Button(
                        onClick = {
                            Login.startActivity(Intent(Login, MainActivity::class.java))
                        },
                        shape = RoundedCornerShape(8.dp),
                        //shape = RectangleShape,


                    ) {
                        Text("Sign up",

                            )
                    }

                }
            }
        }
    }
}