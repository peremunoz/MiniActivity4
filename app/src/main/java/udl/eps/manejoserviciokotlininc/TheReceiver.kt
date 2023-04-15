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
                Toast.makeText(context, R.string.recvsong, Toast.LENGTH_LONG).show()
            } else if (type == "sound") {
                Toast.makeText(context, R.string.recvsound, Toast.LENGTH_LONG).show()
            }
            context.startService(intentService)
        } else {
            Toast.makeText(context, R.string.recvoff, Toast.LENGTH_LONG).show()
            context.stopService(intentService)
        }
    }
}