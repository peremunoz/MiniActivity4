package udl.eps.manejoserviciokotlininc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)
        binding.buttonSong.setOnClickListener(this)

    }

    override fun onClick(src: View) {
        val intent = Intent(this, TheReceiver::class.java)

        when (src.id) {
            R.id.buttonSong -> {
                intent.putExtra("action", "start")
                intent.putExtra("type", "song")
                Toast.makeText(this, "Seleccionado canción", Toast.LENGTH_LONG).show()
            }
            R.id.btnIn -> {
                intent.putExtra("action", "start")
                intent.putExtra("type", "sound")
                Toast.makeText(this, "Seleccionado sonido", Toast.LENGTH_LONG).show()
            }
            else -> {
                intent.putExtra("action", "stop")
                Toast.makeText(this, "Seleccionado finalizar", Toast.LENGTH_LONG).show()
            }
        }

        sendBroadcast(intent)
    }
}