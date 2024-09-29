package com.loc.newsapp.presentation.common

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.model.Source
import com.loc.newsapp.presentation.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.Dimens.SmallIconSize

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth(),
        elevation = cardElevation(
            defaultElevation= 6.dp,
            pressedElevation= 2.dp,
            focusedElevation= 8.dp,
            hoveredElevation= 8.dp,
            draggedElevation= 8.dp,
            disabledElevation= 0.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card)),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.clickable { onClick() }) {

            AsyncImage(
                modifier = Modifier.size(ArticleCardSize).padding(4.dp).clip(MaterialTheme.shapes.medium)

                ,model = ImageRequest.Builder
                    (
                    context = LocalContext.current).data(article.urlToImage).build(),
                contentDescription = "null",
                contentScale = ContentScale.FillBounds,
            )

            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .height(ArticleCardSize)
            ) {

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.text_title),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Row (verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = article.source.name,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body),
                    )
                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                    Icon(
                        painter = painterResource(id = R.drawable.ic_time)
                        , contentDescription = null
                        , modifier = Modifier.size(SmallIconSize),
                        tint = colorResource(id = R.color.body)
                    )

                    Text(
                        text = article.publishedAt,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = colorResource(id = R.color.body),
                    )


                }


            }


        }

    }


}
@Preview
@Composable
fun ArticleCardPreview(){
    ArticleCard(
        article = Article(
            author = "Suraj Sedhain",
            content = "Hi this is suraj sedhain . I am doing nothing",
            description = "This is a written text",
            publishedAt = "2 hours",
            source = Source(id = "", name = "BBC"),
            title = "Her train broke down.",
            url = "",
            urlToImage = "https://image.tmdb.org/t/p/w500/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg"),
        onClick = {}
    )
}