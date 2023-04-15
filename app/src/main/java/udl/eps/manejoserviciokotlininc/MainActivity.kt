package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)
        binding.buttonSong.setOnClickListener(this)

        receiver = TheAutomaticReceiver()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.HEADSET_PLUG")
        registerReceiver(receiver, filter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onClick(src: View) {
        val intent = Intent(this, TheReceiver::class.java)

        when (src.id) {
            R.id.buttonSong -> {
                intent.putExtra("action", "start")
                intent.putExtra("type", "song")
                Toast.makeText(this, R.string.songbtntoast, Toast.LENGTH_LONG).show()
            }
            R.id.btnIn -> {
                intent.putExtra("action", "start")
                intent.putExtra("type", "sound")
                Toast.makeText(this, R.string.soundbtntoast, Toast.LENGTH_LONG).show()
            }
            else -> {
                intent.putExtra("action", "stop")
                Toast.makeText(this, R.string.finbtntoast, Toast.LENGTH_LONG).show()
            }
        }

        sendBroadcast(intent)
    }
}