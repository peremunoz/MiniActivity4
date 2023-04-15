package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TheReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val action = intent.getStringExtra("action")
        val type = intent.getStringExtra("type")
        val intentService = Intent(context, ElServicio::class.java)

        if (action == "start") {
            intentService.putExtra("type", type)
            if (type == "song") {
                Toast.makeText(context, "BroadcastReceiver - Inicio reproducción canción", Toast.LENGTH_LONG).show()
            } else if (type == "sound") {
                Toast.makeText(context, "BroadcastReceiver - Inicio reproducción sonido", Toast.LENGTH_LONG).show()
            }
            context.startService(intentService)
        } else {
            Toast.makeText(context, "BroadcastReceiver - Detención reproducción", Toast.LENGTH_LONG).show()
            context.stopService(intentService)
        }
    }
}