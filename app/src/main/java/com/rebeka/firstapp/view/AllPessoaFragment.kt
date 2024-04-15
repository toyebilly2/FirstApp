package com.rebeka.firstapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rebeka.firstapp.R
import com.rebeka.firstapp.databinding.FragmentAllPessoaBinding
import com.rebeka.firstapp.view.adapter.PessoaAdapter
import com.rebeka.firstapp.viewmodel.AllPessoaViewModel

class AllPessoaFragment: Fragment() {

    // Chamar a viewmodel
    private val viewModel: AllPessoaViewModel by viewModels()

    // Chamar o adapter
    private  lateinit var adapter: PessoaAdapter

    private var _binding: FragmentAllPessoaBinding? = null
    private val binding: FragmentAllPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //configurar o binding
        _binding = FragmentAllPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // quando clicar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value){

        }

        // configura a recycler
        val recycler = binding.rvPessoa
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // observa para adicionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner) {
            adapter.uptadePessoa(it)
        }
        // navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.pessoaFragment)
        }

        // carregar as pessoas cadastradas
        viewModel.load()
    }
}