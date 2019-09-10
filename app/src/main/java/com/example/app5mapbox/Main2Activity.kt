package com.example.app5mapbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import androidx.annotation.NonNull
import com.mapbox.mapboxsdk.annotations.Marker


class Main2Activity : AppCompatActivity() {
    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(
            this,
            "pk.eyJ1IjoiZ2VvcmdlLXBhZGlsbGEiLCJhIjoiY2p6b2k4dG94MDM5azNobW1oaGdpaWRuZyJ9.zb1LHIID_SCsOZjyMbKgUA"
        )
        setContentView(R.layout.activity_main2)



        mapView = findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->

            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
                for (ob in (applicationContext as Variables).objetolist) {
                    mapboxMap?.addMarker(
                        MarkerOptions()
                            .position(LatLng(ob.latitud.toDouble(), ob.longitud.toDouble()))
                            .title(ob.titulo)
                            .setSnippet(ob.dascripcion)

                    )

                    mapboxMap.setOnInfoWindowClickListener { marker ->
                        Snackbar.make(findViewById(R.id.main_layout_id2), marker.snippet , Snackbar.LENGTH_LONG).show();
                        true
                    }

                }




            }


        }

        btnRegresar.setOnClickListener() {

            finish()

        }
    }

 fun  snkbar(mensaje: String) {
        Snackbar.make(findViewById(R.id.main_layout_id), mensaje, Snackbar.LENGTH_LONG).show();

    }

}
