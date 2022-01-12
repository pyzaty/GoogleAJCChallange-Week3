package com.pyza.bloomapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pyza.bloomapp.ui.theme.BloomAppTheme

@Composable
fun PlantThemeCard(plantTheme: PlantTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(136.dp),

        ) {
        Column {
            Image(
                painter = painterResource(
                    id = plantTheme.imageRes
                ),
                contentDescription = "${plantTheme.title} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )
            Text(
                text = plantTheme.title,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .paddingFromBaseline(top = 24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLightPlantThemeCard() {
    BloomAppTheme(darkTheme = false) {
        PlantThemeCard(
            plantTheme = defaultPlantTheme.first()
        )
    }
}

@Preview
@Composable
private fun PreviewDarkPlantThemeCard() {
    BloomAppTheme(darkTheme = true) {
        PlantThemeCard(
            plantTheme = defaultPlantTheme.first()
        )
    }

}