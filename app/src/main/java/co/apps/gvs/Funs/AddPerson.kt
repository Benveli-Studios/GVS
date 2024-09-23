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
        val intent = Intent(this, WelcomeScreen2::class.java)
        intent.putExtra("name", binding.editText.text.toString())
        val imageUser:String
        if (imageUri.equals("a")) imageUser = R.drawable.container.toString() else imageUser = imageUri
        intent.putExtra("imageUser", imageUser)
        startActivity(intent)

    }
}
