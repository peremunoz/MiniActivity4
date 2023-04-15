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
        val intent = Intent(this, ElServicio::class.java)

        if (src.id == R.id.buttonSong) {
            intent.putExtra("type", "song")
            Toast.makeText(this, "Seleccionado canción", Toast.LENGTH_LONG).show()
        } else if (src.id == R.id.btnIn) {
            intent.putExtra("type", "sound")
            Toast.makeText(this, "Seleccionado sonido", Toast.LENGTH_LONG).show()
        }

        when(src.id) {
            R.id.btnIn -> startService(intent)
            R.id.buttonSong -> startService(intent)
            R.id.btnFin -> stopService(intent)
        }
    }
}