package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.ExcluirPessoas
import co.apps.gvs.DataBasse.InteraçõesBásicas.LeituraSimplesPessoa
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityMainBinding
import co.apps.gvs.databinding.ActivityWelcomeBinding

class MainScreen : AppCompatActivity() {

    lateinit var bindingg: ActivityMainBinding
    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingg = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingg.root)

        window.statusBarColor = getColor(R.color.orange1)
        dB = Db(this)

        RecuperarDadosUsuario()

        bindingg.view.setOnClickListener(View.OnClickListener {
            dB.ExcluirPessoas()
            val itent = Intent(this, SplasheScreen::class.java)
            startActivity(itent)
            finish()
        })

    }

    fun RecuperarDadosUsuario(){
        val dadosUsuario = dB.LeituraSimplesPessoa(this)
        bindingg.imagemUsuario.setImageURI(dadosUsuario.ObjImagemPessoas?.toUri())
    }

}