package com.pyza.bloomapp

class InMemoryPlantService:PlantRepository {
    override suspend fun fetchThemes(): List<PlantTheme> {
        return defaultPlantTheme
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenItems
    }
}