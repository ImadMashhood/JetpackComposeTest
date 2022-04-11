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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    Card(elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 10.dp, start = 16.dp, end = 16.dp)
            //.border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
    ) {
        BoxWithConstraints() {
            val constraints = if(minWidth < 600.dp){
                portraitConstraint(margin = 16.dp)
            }
            else{
                landScapeConstraints(margin = 16.dp)
            }
            ConstraintLayout(constraints) {
                Image(painter = painterResource(id = R.drawable.imad),
                    contentDescription = "Imad Profile Picture",
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Red,
                            shape = CircleShape
                        )
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
                Text(text="Imad Mashhood", fontWeight = FontWeight.Bold, modifier = Modifier.layoutId("nameText"))

                Text(text = "Katy, TX", modifier = Modifier.layoutId("aboutText"))

                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")

                ) {
                    ProfileStats(amnt = "48", stat = "Posts")
                    ProfileStats(amnt = "617", stat = "Followers")
                    ProfileStats(amnt = "342", stat = "Following")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonFollow")) {
                    Text(text = "Follow")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.layoutId("buttonMessage")) {
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

private fun landScapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("countryText")
        val rowStats = createRefFor("rowstats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        constrain(image){
            top.linkTo(parent.top,margin = margin)
            start.linkTo(parent.start,margin = margin)
        }
        constrain(nameText){
            start.linkTo(image.start)
            top.linkTo(image.bottom)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats){
            top.linkTo(image.top)
            start.linkTo(image.end,margin = margin)
            end.linkTo(parent.end)
        }

        constrain(buttonFollow){
            top.linkTo(rowStats.bottom,margin =16.dp)
            start.linkTo(rowStats.start)
            end.linkTo(buttonMessage.start)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom,margin =16.dp)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(countryText.bottom)
            width = Dimension.wrapContent
        }
    }
}

private fun portraitConstraint(margin: Dp): ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val countryText = createRefFor("aboutText")
        val rowStats = createRefFor("rowStats")
        val buttonFollow = createRefFor("buttonFollow")
        val buttonMessage = createRefFor("buttonMessage")
        val guideLine = createGuidelineFromTop(0.05f)
        constrain(image){
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(countryText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats){
            top.linkTo(countryText.bottom)
        }
        constrain(buttonFollow){
            top.linkTo(rowStats.bottom,margin = margin)
            start.linkTo(parent.start)
            end.linkTo(buttonMessage.start)
            width = Dimension.wrapContent
        }
        constrain(buttonMessage){
            top.linkTo(rowStats.bottom,margin = margin)
            start.linkTo(buttonFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}
