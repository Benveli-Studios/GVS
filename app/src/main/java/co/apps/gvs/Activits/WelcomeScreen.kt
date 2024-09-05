package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.DataBasse.dBNomePessoa
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcomeBinding

class WelcomeScreen : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding
    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        dB = Db(this)

        binding.btnNext.setOnClickListener {

            if (binding.editText.text.toString().isEmpty()) {
                binding.text1.setTextColor(getColor(R.color.red1))
            }else{
                binding.text1.setTextColor(getColor(R.color.black))
                val nome = binding.editText.text.toString()
                val text : String
                val pessoaNome = Objeto(ObjNomesPessoas = nome)
                if (dB.SalvarPessoas(pessoaNome)) text = "$nome adicionado com sucesso" else text = "Erro ao adicionar $nome"
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, WelcomeScreen::class.java)
                startActivity(intent)

            }

        }

    }
}