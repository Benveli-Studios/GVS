package co.apps.gvs.Funs

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import co.apps.gvs.Activits.WelcomeScreen
import co.apps.gvs.Activits.WelcomeScreen2
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R

fun WelcomeScreen.AddPerson() {
    if (binding.editText.text.isEmpty()) {
        binding.text1.setTextColor(ContextCompat.getColor(this, R.color.red1))
    }else{
        val nome = binding.editText.text.toString()
        val text : String
        val pessoaNome = Objeto(ObjNomesPessoas = nome)
        if (dB.SalvarPessoas(pessoaNome)) text = "$nome adicionado com sucesso" else text = "Erro ao adicionar $nome"
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, WelcomeScreen2::class.java)
        startActivity(intent)

    }
}
