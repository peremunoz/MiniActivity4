package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TheAutomaticReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val intentService = Intent(context, ElServicio::class.java)

        if (intent.getIntExtra("state", 0) == 0) {
            Toast.makeText(context, R.string.recvplugoff, Toast.LENGTH_LONG).show()
            context.stopService(intentService)
        } else {
            intentService.putExtra("type", "song")
            Toast.makeText(context, R.string.recvplugon, Toast.LENGTH_LONG).show()
            context.startService(intentService)
        }
    }
}