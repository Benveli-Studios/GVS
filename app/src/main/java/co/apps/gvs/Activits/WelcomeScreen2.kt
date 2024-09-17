package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.DataBasse.InteraçõesBásicas.VerificadoPopulaçãoPessoas
import co.apps.gvs.Funs.AddPerson2
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcome2Binding
import co.apps.gvs.databinding.ActivityWelcomeBinding

class WelcomeScreen2 : AppCompatActivity() {

    lateinit var binding: ActivityWelcome2Binding
    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.orange1)
        dB = Db(this)

        binding.btnNext.setOnClickListener(View.OnClickListener{
            AddPerson2(intent.getStringExtra("name").toString())
        })

    }
}