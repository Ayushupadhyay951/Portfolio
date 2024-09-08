package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortfolioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Portfolio(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Portfolio(modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        val isOpen = remember {
            mutableStateOf(false)
        }
        Surface(
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.loginui),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Divider()
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Ayush Upadhyay",
                    style = TextStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "ANDROID COMPOSE DEVELOPER",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.logoinsta),
                        contentDescription = null, modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = " __aarush_upadhyay9997",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.githublogo),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "       AyushUpadhyay951    ",
                        modifier = Modifier.padding(8.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.padding(4.dp))
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ytdd),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(text = "         AarushUpadhyay5558", fontWeight = FontWeight.Bold)
                }
                Button(onClick = { isOpen.value = !isOpen.value }) {
                    Text(text = "PROJECT", fontFamily = FontFamily.Serif)

                }
                if (isOpen.value) {
                    LazyColumn {
                        items(getProjectList()) {
                            ProjectItem(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.loginui),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp))
        Column() {
            Text(
                text = project.name,
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            )
            Text(text = project.desc, style = MaterialTheme.typography.bodySmall)
        }

    }

}

data class Project(
    val name: String,
    val desc: String
)

fun getProjectList(): List<Project> {
    return listOf(
        Project(
            name = "ToDO list",
            desc = "Help to make list"
        ),
        Project(
            name = "Pizza Application",
            desc = "it calculate the total cost"
        ),
        Project(
            name = "Weather Application",
            desc = "Help to predict weather"
        ),
        Project(
            name = "FireBase Application",
            desc = "it help to login Online"
        ),
        Project(
            name = "Portfolio Application",
            desc = "Help to introduce you"
        ),
        Project(
            name = "Login UI Application",
            desc = "Here you enter E-mail and Password "
        ),
        Project(
            name = "ComposeMVVM Application",
            desc = "Compose Application "
        ),
        Project(
            name = "My first Application",
            desc = "Basic knowledge of cards and jet pack "
        ),
        Project(
            name = "Animation LoginUI Application",
            desc = "LoginUI animation "
        )
    )
}


@Preview(showSystemUi = true)
@Composable
private fun PortfolioPreveiw() {
    Portfolio()
}