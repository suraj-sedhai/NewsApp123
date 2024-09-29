package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Get Instant News daily!!",
        "NewsApp gets you latest news from across the globe few clicks away.",
        R.drawable.onboarding1
    ),
    Page(
        "Share important news with your friends!!",
        "NewsApp lets you share the news articles with your friends through email or other social media platforms.",
        R.drawable.onboarding2
    ),
    Page(
        "Click GetStarted to begin with your journey ",
        "Enjoy news updates and stay informed with our app.",
        R.drawable.onboarding3
    ),
)