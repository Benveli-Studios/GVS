package co.apps.gvs.Activits

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityMainBinding
import co.apps.gvs.databinding.ActivityWelcomeBinding

class MainScreen : AppCompatActivity() {

    lateinit var bindingg: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingg = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(bindingg.root)



    }
}