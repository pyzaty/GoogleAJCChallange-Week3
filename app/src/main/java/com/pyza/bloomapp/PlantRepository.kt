package com.pyza.bloomapp

/**
 * [PlantRepository] servers as a model layer for our HomeScreen.
 * This allows us to fetch Themes as HomeGardeItems
 *
 * We use an interface so we could create a multiple implementations and swap tem out.
 */
interface PlantRepository {
    suspend fun fetchThemes(): List<PlantTheme>
    suspend fun fetchHomeGardenItems(): List<PlantTheme>
}