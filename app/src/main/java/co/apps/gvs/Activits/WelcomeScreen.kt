package co.apps.gvs.Activits

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.Funs.AddPerson
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcomeBinding

class WelcomeScreen : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding
    lateinit var dB: Db
    var imageUri = "a"

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.orange1)
        dB = Db(this)

        binding.btnNext.setOnClickListener(View.OnClickListener {
            AddPerson()
        })

        binding.imageUsser.setOnClickListener(View.OnClickListener {
            PegarImagemGaleria()
        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            binding.imageUsser.setImageURI(data?.data)
            imageUri = data?.data.toString()
        }
    }

    fun PegarImagemGaleria(){
        val itent = Intent(Intent.ACTION_PICK)
        itent.type = "image/*"
        startActivityForResult(itent, IMAGE_REQUEST_CODE)
    }
}