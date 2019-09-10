package com.example.app5mapbox

import android.app.Application

class Variables : Application(){

    public var objetolist= mutableListOf <Objeto>()
}

 class Objeto(
    var dascripcion : String = "",
    var titulo : String = "",
    var latitud : Float = 0.0f,
    var longitud : Float = 0.0f


)