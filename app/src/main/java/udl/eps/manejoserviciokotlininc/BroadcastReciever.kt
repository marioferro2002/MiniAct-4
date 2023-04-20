package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        when (action) {
            "PLAY_SOUND" -> {
                val i = Intent(context, ElServicio::class.java)
                i.putExtra("sound_type", "sound")
                context.startService(i)
                Toast.makeText(
                    context,
                    "BroadcastReceiver - Inicio reproducción sonido",
                    Toast.LENGTH_LONG
                ).show()
            }
            "PLAY_SONG" -> {
                val i = Intent(context, ElServicio::class.java)
                i.putExtra("sound_type", "song")
                context.startService(i)
                Toast.makeText(
                    context,
                    "BroadcastReceiver - Inicio reproducción canción",
                    Toast.LENGTH_LONG
                ).show()
            }
            "STOP_PLAYBACK" -> {
                val i = Intent(context, ElServicio::class.java)
                context.stopService(i)
                Toast.makeText(
                    context,
                    "BroadcastReceiver - Detencion reproduccion",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}