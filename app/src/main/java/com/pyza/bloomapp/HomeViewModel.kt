package com.pyza.bloomapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * The [HomeViewModel] is providing data to [HomeViewState] through [PlantRepository] interface,
 * so this data could be exposed by the [viewState] flow in order for the view to render relevant
 * information
 */
class HomeViewModel(
    private val plantRepository: PlantRepository
) : ViewModel() {

    private val _viewState = mutableStateOf(HomeViewState())
    val viewState: MutableState<HomeViewState> = _viewState

    init {
        fetchPlantThemes()
        fetchHomeGardenItems()
    }

    private fun fetchPlantThemes() {
        viewModelScope.launch {
            val plantThems = plantRepository.fetchThemes()
            _viewState.value = _viewState.value.copy(
                plantThemes = plantThems
            )
        }
    }

    private fun fetchHomeGardenItems() {
        viewModelScope.launch {
            val gardenItems = plantRepository.fetchHomeGardenItems()
            _viewState.value = _viewState.value.copy(
                homeGardenItems = gardenItems
            )
        }
    }
}