package com.example.app5mapbox

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInsertar.setOnClickListener() {
            verificar()
        }
    }

    fun verificar() {
        if (!txtDescripcion.text.isEmpty() && !txtLat.text.isEmpty() && !txtLong.text.isEmpty() && !txtTitulo.text.isEmpty()) {
            if (txtLat.text.toString().toFloat() < -90 || txtLat.text.toString().toFloat() > 90) {
                snkbar("Latitud incorrecta")
                return
            }
            if (txtLong.text.toString().toFloat() < -180 || txtLong.text.toString().toFloat() > 160) {
                snkbar("Longitud incorrecta")
                return
            }
            var ob = Objeto(
                txtDescripcion.text.toString(),
                txtTitulo.text.toString(),
                txtLat.text.toString().toFloat(),
                txtLong.text.toString().toFloat()
            )
            (applicationContext as Variables).objetolist.add(ob)
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        } else {
            snkbar("Llena todos los campos")
        }
    }

    fun snkbar(mensaje: String) {
        Snackbar.make(findViewById(R.id.main_layout_id), mensaje, Snackbar.LENGTH_LONG).show();
    }

    override fun onResume() {
        super.onResume()
        txtDescripcion.setText("")
        txtTitulo.setText("")
        txtLat.setText("")
        txtLong.setText("")

    }
}
