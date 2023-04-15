package udl.eps.manejoserviciokotlininc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio: Service() {

    private var soundPlayer: MediaPlayer? = null
    private var songPlayer: MediaPlayer? = null

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
            songPlayer = MediaPlayer.create(applicationContext, R.raw.song)
            songPlayer!!.isLooping = true
            Toast.makeText(this, R.string.songservon, Toast.LENGTH_LONG).show()
            songPlayer!!.start()
        } else if (type == "sound") {
            soundPlayer = MediaPlayer.create(applicationContext, R.raw.train)
            soundPlayer!!.isLooping = true
            Toast.makeText(this, R.string.soundservon, Toast.LENGTH_LONG).show()
            soundPlayer!!.start()
        }

        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show()
        if (soundPlayer != null && soundPlayer!!.isPlaying) {
            soundPlayer!!.stop()
        }
        if (songPlayer != null && songPlayer!!.isPlaying) {
            songPlayer!!.stop()
        }
    }
}