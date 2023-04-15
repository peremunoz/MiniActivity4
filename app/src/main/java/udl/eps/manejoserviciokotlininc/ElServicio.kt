package udl.eps.manejoserviciokotlininc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio: Service() {

    private var player: MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        val type = intent!!.getStringExtra("type")
        if (type == "song") {
            player = MediaPlayer.create(applicationContext, R.raw.song)
            player!!.isLooping = true
            Toast.makeText(this, "Servicio canción activado", Toast.LENGTH_LONG).show()
        } else if (type == "sound") {
            player = MediaPlayer.create(applicationContext, R.raw.train)
            player!!.isLooping = true
            Toast.makeText(this, "Servicio sonido activado", Toast.LENGTH_LONG).show()
        }

        player!!.start()
        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show()
        player!!.stop()
    }
}