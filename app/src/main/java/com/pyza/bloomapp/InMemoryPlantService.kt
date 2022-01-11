package com.pyza.bloomapp

import kotlinx.coroutines.delay

class InMemoryPlantService:PlantRepository {
    override suspend fun fetchThemes(): List<PlantTheme> {
        delay(5000)
        return defaultPlantTheme
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenItems
    }
}