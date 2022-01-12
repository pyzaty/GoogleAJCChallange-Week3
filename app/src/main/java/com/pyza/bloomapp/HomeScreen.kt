package com.pyza.bloomapp

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pyza.bloomapp.ui.theme.BloomAppTheme

@Composable
fun HomeScreen(){

    val factory= object: ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val repository=InMemoryPlantService()

            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                plantRepository = repository
            ) as T
        }
    }

    val homeViewModel : HomeViewModel = viewModel(key = null, factory = factory)

    val currentState: State<HomeViewState> = homeViewModel.viewState.collectAsState()
    HomeScreenScaffold(state = currentState.value)
}

@Composable
fun HomeScreenScaffold(
    state: HomeViewState
){
    Scaffold(
        bottomBar = {
            BloomBottomBar()
        }
    ) { paddingValues ->
        if (state.showLoading) {
            HomeScreenLoader(paddingValues)
        } else {
            HomeScreenContent(state, paddingValues)
        }
    }
}

@Composable
fun HomeScreenLoader(paddingValues: PaddingValues){
    Box(
    modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun BloomBottomBar() {
    BottomAppBar(
        backgroundColor=MaterialTheme.colors.primary
    ){
        BloomBottomNavigationItem(true,Icons.Default.Home,"Home")
        BloomBottomNavigationItem(selected = false, icon =Icons.Default.FavoriteBorder , labelText = "Favourites")
        BloomBottomNavigationItem(selected = false, icon = Icons.Default.AccountCircle , labelText ="Profile" )
        BloomBottomNavigationItem(selected = false, icon =Icons.Default.ShoppingCart , labelText ="Cart" )
    }
}

@Composable
private fun RowScope.BloomBottomNavigationItem(selected:Boolean, icon:ImageVector, labelText:String) {
    BottomNavigationItem(selected = selected, onClick = { /*TODO*/ },
        icon = {
            Icon(
                icon,
                contentDescription = null
            )
        },
        label = {
            Text(labelText)
        })
}

@Composable
private fun HomeScreenContent(
    state:HomeViewState,
    paddingValues: PaddingValues) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            SearchInput()
            BrowseThemesSection(state.plantThemes)

            HomeGardenSection(state.homeGardenItems)
        }
    }
}

@Composable
private fun HomeGardenSection(
    homeGardenItems:List<PlantTheme>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ){
        Text(
            text = "Design your home garden",
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .weight(1F)
        )
        Icon(
            Icons.Default.FilterList,
            contentDescription = "Filter",
            modifier=Modifier
                .size(24.dp)
        )
    }
    
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        homeGardenItems.forEach{
            HomeGardeListItem(plantTheme =it )
        }

    }

}

@Composable
private fun BrowseThemesSection(themes:List<PlantTheme>) {
    Text(
        text = "Browse themes",
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(16.dp)
    ){
        themes.forEach{ theme ->
            PlantThemeCard(theme)

        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun PreviewDarkMode(){
    val previewState=HomeViewState(
        plantThemes = defaultPlantTheme,
        homeGardenItems = homeGardenItems
    )
    BloomAppTheme(darkTheme = true) {
        HomeScreenScaffold(previewState)
    }
}

@Preview
@Composable
private fun PreviewLightMode(){
    val previewState=HomeViewState(
        plantThemes = defaultPlantTheme,
        homeGardenItems = homeGardenItems
    )
        BloomAppTheme(darkTheme = false) {
            HomeScreenScaffold(previewState)
        }
}