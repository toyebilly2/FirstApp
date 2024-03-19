package com.rebeka.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rebeka.firstapp.databinding.FragmentVerificarBinding

class VerificarFragment : Fragment() {
    private var _binding: FragmentVerificarBinding? = null
    private val binding: FragmentVerificarBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVerificarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
