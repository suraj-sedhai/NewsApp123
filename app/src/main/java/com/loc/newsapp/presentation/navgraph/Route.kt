package com.loc.newsapp.presentation.navgraph

sealed class Route(val route: String) {
    object AppStartNavigation : Route("appStartNavigation")
    object OnBoardingScreen : Route("onBoardingScreen")

    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen : Route("newsNavigator")
    object SearchScreen : Route("searchScreen")

    object DetailsScreen : Route("detailsScreen")
    object HomeScreen : Route("homeScreen")
    object BookmarkScreen : Route("bookmarkScreen")

}


