package udl.eps.manejoserviciokotlininc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        intent = Intent(this, ElServicio::class.java)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rpSn.setOnClickListener(this)
        binding.rpCn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)

    }

    override fun onClick(src: View) {

        when(src.id) {
            binding.rpSn.id -> {
                intent.putExtra("sound_type", "sound")
                startService(intent)
            }
            binding.rpCn.id -> {
                intent.putExtra("sound_type", "song")
                startService(intent)
            }
            binding.btnFin.id -> {
                stopService(intent)
            }
        }
    }
}