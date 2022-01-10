package com.pyza.bloomapp

data class PlantTheme(val imageRes:Int,val title:String)

val defaultPlantTheme= listOf(
    PlantTheme(R.drawable.huy_phan,"Huy Phan"),
    PlantTheme(R.drawable.fabian_stroobants,"Fabian Stroobants"),
    PlantTheme(R.drawable.karolina_grabowska,"Karolina Grabowska"),
    PlantTheme(R.drawable.katarzyna_modrzejewska,"Katarzyna Modrzejewska"),
    PlantTheme(R.drawable.melvin_vito,"Melvin Vito"),
    PlantTheme(R.drawable.plant6208086,"6208086"),
    PlantTheme(R.drawable.plant6208087,"6208087"),
    PlantTheme(R.drawable.quang_nguyen_vinh,"Guang Nguyen Ving"),
    PlantTheme(R.drawable.sidnei_maia,"Signei Maia"),
    PlantTheme(R.drawable.volkan_vardar,"Volkan Vardar")

)

val defaultGardenThemes = listOf(
    PlantTheme(R.drawable.katarzyna_modrzejewska,"Monstera"),
    PlantTheme(R.drawable.plant6208087,"Anlgomea"),
    PlantTheme(R.drawable.karolina_grabowska,"Peace Lily"),
    PlantTheme(R.drawable.volkan_vardar,"Volkan"),
    PlantTheme(R.drawable.plant6208086,"Sneaky plant"),
    PlantTheme(R.drawable.quang_nguyen_vinh,"Vinh"),
    PlantTheme(R.drawable.melvin_vito,"Vito Plant")
)