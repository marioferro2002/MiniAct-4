package udl.eps.manejoserviciokotlininc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.PackageManagerCompat

class BroadcastReciever : BroadcastReceiver() {

    var serviceIntent: Intent? = null



    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        when (action) {
            "PLAY_SOUND" -> {
                println("PLAY_SOUND")
                playSound(context)
            }
            "PLAY_SONG" -> {
                playSong(context)
            }
            "STOP_PLAYBACK" -> {
                stopPlayback(context)
            }
            Intent.ACTION_HEADSET_PLUG -> {
                val state = intent.getIntExtra("state", -1)
                if (state == 1) headSetPlugIn(context)
                else if (state == 0) headSetPlugOut(context)
            }
        }
    }

    private fun playSound(context: Context) {
        serviceIntent = Intent(context, ElServicio::class.java)
        serviceIntent!!.putExtra("sound_type", "sound")
        context.startService(serviceIntent!!)
        Toast.makeText(
            context,
            "BroadcastReceiver - Inicio reproducción sonido",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun playSong(context: Context) {
        serviceIntent = Intent(context, ElServicio::class.java)
        serviceIntent!!.putExtra("sound_type", "song")
        context.startService(serviceIntent!!)
        Toast.makeText(
            context,
            "BroadcastReceiver - Inicio reproducción canción",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun stopPlayback(context: Context) {
        serviceIntent?.let { context.stopService(serviceIntent!!) }
        Toast.makeText(
            context,
            "BroadcastReceiver - Detencion reproduccion",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun headSetPlugIn(context: Context) {
        Toast.makeText(context, "BroadcastReceiver - HEADSET_PLUG-ON", Toast.LENGTH_SHORT).show()
        serviceIntent = Intent(context, ElServicio::class.java)
        serviceIntent!!.putExtra("sound_type", "song")
        context.startService(serviceIntent!!)
        Toast.makeText(
            context,
            "BroadcastReceiver - Inicio reproducción canción",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun headSetPlugOut(context: Context) {
        Toast.makeText(
            context,
            "BroadcastReceiver - HEADSET_PLUG-OFF",
            Toast.LENGTH_SHORT
        ).show()
        serviceIntent?.let { context.stopService(serviceIntent!!) }
        Toast.makeText(
            context,
            "BroadcastReceiver - Detencion reproduccion",
            Toast.LENGTH_LONG
        ).show()
    }
}