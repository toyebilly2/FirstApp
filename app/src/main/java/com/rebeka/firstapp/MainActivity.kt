package com.rebeka.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rebeka.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnEnviar.setOnClickListener {
            var telefone = binding.edtTelefone.editableText.toString()
            if (telefone.length == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }
            else {
                binding.tvTelefone.text = "Telefone: O numero esta incorreto "
            }

            var email = binding.edtEmail.editableText.toString()
            if (email.contains("@")&& email.substringAfter("@").contains(".com"))
            {
                binding.tvEmail.text = "Email: ${email}"
            }else {
                binding.tvEmail.text = "Email: O email esta incorreto}"
            }
        }
    }
}