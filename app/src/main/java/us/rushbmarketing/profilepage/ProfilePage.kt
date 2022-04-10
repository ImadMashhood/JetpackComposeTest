package us.rushbmarketing.profilepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    Card(elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
            //.border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        ConstraintLayout {
            val(image, nameText, aboutText, rowStats,
                buttonFollow, buttonMessage) = createRefs()
            val guideLine =createGuidelineFromTop(0.02f)
            Image(painter = painterResource(id = R.drawable.imad),
                contentDescription = "Imad Profile Picture",
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    ).constrainAs(image){
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            Text(text="Imad Mashhood",
                    modifier = Modifier.constrainAs(nameText){
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

            Text(text = "Katy, TX",
                modifier = Modifier.constrainAs(aboutText){
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(rowStats){
                        top.linkTo(aboutText.bottom)

                    }
            ) {
                ProfileStats(amnt = "48", stat = "Posts")
                ProfileStats(amnt = "617", stat = "Followers")
                ProfileStats(amnt = "342", stat = "Following")
            }
            Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(buttonFollow){
                top.linkTo(rowStats.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(buttonMessage.start)
                width= Dimension.wrapContent
            }
            ) {
                Text(text = "Follow")
            }
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(buttonMessage){
                    top.linkTo(rowStats.bottom, margin = 16.dp)
                    start.linkTo(buttonFollow.end)
                    end.linkTo(parent.end)
                    width= Dimension.wrapContent
                }
            ) {
                Text(text = "Message")
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
