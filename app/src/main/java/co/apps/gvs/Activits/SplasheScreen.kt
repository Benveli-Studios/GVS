package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.VerificadoPopulaçãoPessoas
import co.apps.gvs.R

class SplasheScreen : AppCompatActivity() {

    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashe)

        dB = Db(this)
        window.statusBarColor = getColor(R.color.orange1)

        val test = dB.VerificadoPopulaçãoPessoas(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (test == -1 || test == 4){
                val itent = Intent(this, MainScreen::class.java)
                startActivity(itent)
                finish()
            } else if(test == 0 || test == 1){
                val itent = Intent(this, WelcomeScreen::class.java)
                startActivity(itent)
                finish()
            } else if(test == 2 || test == 3){
            val itent = Intent(this, WelcomeScreen2::class.java)
            startActivity(itent)
            finish()
            } else if(test == 4) {
                Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show()
                val itent = Intent(this, SplasheScreen::class.java)
                startActivity(itent)
                finish()
            }
        }, 2000)
    }
}