package udl.eps.manejoserviciokotlininc

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var broadcastReciever: BroadcastReciever
    private val filter = IntentFilter().apply {
        addAction("PLAY_SOUND")
        addAction("PLAY_SONG")
        addAction("STOP_PLAYBACK")
        addAction(Intent.ACTION_HEADSET_PLUG)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        broadcastReciever = BroadcastReciever()
        registerReceiver(broadcastReciever, filter)


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rpSn.setOnClickListener(this)
        binding.rpCn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)

    }

    override fun onDestroy() {
        unregisterReceiver(broadcastReciever)
        super.onDestroy()
    }

    override fun onClick(src: View) {

        when(src.id) {
            binding.rpSn.id -> {
                Toast.makeText(this, R.string.selSound, Toast.LENGTH_SHORT).show()
                val intent = Intent("PLAY_SOUND")
                sendBroadcast(intent)
            }
            binding.rpCn.id -> {
                val intent = Intent("PLAY_SONG")
                sendBroadcast(intent)
            }
            binding.btnFin.id -> {
                val intent = Intent("STOP_PLAYBACK")
                sendBroadcast(intent)
            }
        }
    }
}