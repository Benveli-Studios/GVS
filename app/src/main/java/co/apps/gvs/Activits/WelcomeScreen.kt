package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.Funs.AddPerson
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcomeBinding

class WelcomeScreen : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding
    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.orange1)
        dB = Db(this)

        binding.btnNext.setOnClickListener(View.OnClickListener {
            AddPerson()
        })

    }
}