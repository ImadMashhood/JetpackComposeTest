package us.rushbmarketing.profilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Card() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.imad),
                contentDescription = "Imad Profile Picture",
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Text(text="Imad Mashhood")
            Text(text = "Katy, TX")
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats(amnt = "48", stat = "Posts")
                ProfileStats(amnt = "617", stat = "Followers")
                ProfileStats(amnt = "342", stat = "Following")
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Message")
                }
            }
        }
    }
}

@Composable
fun ProfileStats(amnt: String, stat: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = amnt, fontWeight = FontWeight.Bold)
        Text(text = stat)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}
