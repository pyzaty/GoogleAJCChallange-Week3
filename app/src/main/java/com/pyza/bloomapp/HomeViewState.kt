package com.pyza.bloomapp


/**
 *  This data class represents View state for HomeScreen.
 *  All of this data should be formatted in a way that the home screen can just
 *  take the information and display it.
 */
data class HomeViewState(
    val plantThemes:List<PlantTheme> = emptyList(),
    val homeGardenItems:List<PlantTheme> = emptyList()
){}
