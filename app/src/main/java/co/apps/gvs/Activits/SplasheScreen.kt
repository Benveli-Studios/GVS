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
import co.apps.gvs.DataBasse.InteraçõesBásicas.ExcluirPessoas
import co.apps.gvs.DataBasse.InteraçõesBásicas.VerificadoPopulaçãoPessoas
import co.apps.gvs.R

class SplasheScreen : AppCompatActivity() {

    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashe)

        dB = Db(this)
        window.statusBarColor = getColor(R.color.orange1)

        //dB.ExcluirPessoas()

        val test = dB.VerificadoPopulaçãoPessoas()

        Handler(Looper.getMainLooper()).postDelayed({
            if (test){
                val itent = Intent(this, MainScreen::class.java)
                startActivity(itent)
                finish()
            } else{
                val itent = Intent(this, WelcomeScreen::class.java)
                startActivity(itent)
                finish()
            }
        }, 2000)
    }
}