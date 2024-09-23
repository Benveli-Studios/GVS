package co.apps.gvs.Activits

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import co.apps.gvs.DataBasse.Db
import co.apps.gvs.Funs.AddPerson2
import co.apps.gvs.R
import co.apps.gvs.databinding.ActivityWelcome2Binding

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
            AddPerson2(intent.getStringExtra("name").toString(), intent.getStringExtra("imageUser").toString())
        })

    }
}