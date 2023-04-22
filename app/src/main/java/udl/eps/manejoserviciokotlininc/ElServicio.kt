package udl.eps.manejoserviciokotlininc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ElServicio : Service() {


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show()

        val extras = intent?.extras
        val tipo = extras?.getString("sound_type")

        when (tipo) {
            "sound" -> playSound()
            "song" -> playSong()
        }
        return startId
    }

    override fun onDestroy() {
        super.onDestroy()

        offSoundPlayer()
        offSongPlayer()

        Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show()
    }
    
    private fun playSound() {
        if (soundPlayer == null) soundPlayer = MediaPlayer.create(this, R.raw.train)
        Toast.makeText(this, R.string.selSound, Toast.LENGTH_SHORT).show()
        soundPlayer?.start()
    }
    private fun playSong() {
        if (songUri != null) getSongFromUri()
        else if (songPlayer == null) songPlayer = MediaPlayer.create(this, R.raw.music)
        Toast.makeText(this, R.string.selSong, Toast.LENGTH_SHORT).show()
        songPlayer?.start()
    }
    
    private fun getSongFromUri() {
        songPlayer = MediaPlayer()
        songPlayer?.setDataSource(this, songUri!!)
        songPlayer?.prepare()
    }
    
    private fun offSoundPlayer() {
        soundPlayer?.stop()
    }
    private fun offSongPlayer() {
        songPlayer?.stop()
    }
}