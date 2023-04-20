package udl.eps.manejoserviciokotlininc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udl.eps.manejoserviciokotlininc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIn.setOnClickListener(this)
        binding.btnFin.setOnClickListener(this)

    }

    override fun onClick(src: View) {

        when(src.id) {
            R.id.btnIn -> startService(intent)
            R.id.btnFin -> stopService(intent)
        }
    }
}