package com.rebeka.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rebeka.firstapp.databinding.FragmentPessoaBinding
import com.rebeka.firstapp.service.model.Pessoa
import com.rebeka.firstapp.viewmodel.AllPessoaViewModel
import com.rebeka.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime


class PessoaFragment : Fragment() {

    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!
    private val viewModel: PessoaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()

            binding.tvNome.text = "$nome"

            val anoNascimento = binding.edtAnoNacimento.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            val idade = anoAtual - anoNascimento.toInt()

            binding.tvIdade.text = "Idade: ${idade}"

            val pessoa = Pessoa(
                nome = nome,
                idade = idade
            )

            viewModel.insert(pessoa)

            binding.edtNome.editableText.clear()
            binding.edtAnoNacimento.editableText.clear()
            findNavController().navigateUp()
        }
    }
}