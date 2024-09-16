package co.apps.gvs.Funs

import android.content.Intent
import android.widget.Toast
import co.apps.gvs.Activits.MainScreen
import co.apps.gvs.Activits.WelcomeScreen2
import co.apps.gvs.DataBasse.InteraçõesBásicas.SalvarPessoas
import co.apps.gvs.Objetos.Objeto
import co.apps.gvs.R

fun WelcomeScreen2.AddPerson2() {
    val a = if (binding.editText1.text.toString().isEmpty()) {
        binding.text1.setTextColor(getColor(R.color.red1))
        false
    }else{
        binding.text1.setTextColor(getColor(R.color.black))
        true}

    val b = if (binding.editText2.text.toString().isEmpty()) {
        binding.text2.setTextColor(getColor(R.color.red1))
        false
    }else{
        binding.text1.setTextColor(getColor(R.color.black))
        true}

    if(a && b) {
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
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}
