package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat

class BroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Toast.makeText(context, "BroadcastReceiver - $action", Toast.LENGTH_LONG).show()
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
            Intent.ACTION_HEADSET_PLUG -> {
                val state = intent.getIntExtra("state", -1)
                if (state == 1) {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-ON", Toast.LENGTH_SHORT).show()
                    val i = Intent(context, ElServicio::class.java)
                    i.putExtra("sound_type", "song")
                    context.startService(i)
                    Toast.makeText(
                        context,
                        "BroadcastReceiver - Inicio reproducción canción",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (state == 0) {
                    Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-OFF", Toast.LENGTH_SHORT).show()
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
}