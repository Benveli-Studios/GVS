package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcome2Binding
import co.apps.gvs.databinding.ActivityWelcomeBinding

class WelcomeScreen2 : AppCompatActivity() {

    lateinit var binding: ActivityWelcome2Binding
    lateinit var dB: Db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWelcome2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        dB = Db(this)

        binding.btnNext.setOnClickListener {

            if (binding.editText1.text.toString().isEmpty()) {
                binding.text1.setTextColor(getColor(R.color.red1))
            } else if (binding.editText2.text.toString().isEmpty()) {
                binding.text2.setTextColor(getColor(R.color.red1))
            } else {
                binding.text1.setTextColor(getColor(R.color.black))
                binding.text2.setTextColor(getColor(R.color.black))
                val email = binding.editText1.text.toString()
                val telefone = binding.editText2.text.toString()
                val text: String
                val pessoaNome = Objeto(ObjNumeroPessoas = telefone, ObjNomesPessoas = email)
                if (dB.SalvarPessoas(pessoaNome)) text =
                    "$email e $telefone adicionado com sucesso" else text =
                    "Erro ao adicionar $email e $telefone"
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, WelcomeScreen::class.java)
                startActivity(intent)
            }
        }

    }
}