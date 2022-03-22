package udl.eps.manejoserviciokotlininc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInicio: Button = findViewById(R.id.btnIn)
        val btnFin: Button = findViewById(R.id.btnFin)

        btnInicio.setOnClickListener(this)
        btnFin.setOnClickListener(this)

    }

    override fun onClick(src: View) {

        when(src.id) {
            R.id.btnIn -> startService(`in`)
            R.id.btnFin -> stopService(`in`)
        }
    }
}