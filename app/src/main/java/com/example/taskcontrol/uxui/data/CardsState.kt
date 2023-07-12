package com.example.taskcontrol.uxui.data

data class CardsState(
    val title: String = "",
    val id: Int?= null, /*TODO: Alterar ID de int para UUID*/
    val userAttached: String = "",
    val state: String = ""

)