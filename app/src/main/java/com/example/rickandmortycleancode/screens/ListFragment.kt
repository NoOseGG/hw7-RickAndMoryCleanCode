package com.example.rickandmortycleancode.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortycleancode.databinding.FragmentListBinding
import com.example.rickandmortycleancode.extensions.addSpaceDecoration
import com.example.rickandmortycleancode.paging.CharacterDataAdapter
import com.example.rickandmortycleancode.viewmodel.ViewModelList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


class ListFragment : Fragment(), KoinComponent {

    private var _binding: FragmentListBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: ViewModelList by viewModel()
    private val adapter by lazy {
        CharacterDataAdapter(requireContext()) { character ->
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(character.name, character.id)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.addSpaceDecoration(SPACE_DECORATION)
        }

        lifecycleScope.launch {
            viewModel.characters.collectLatest {
                adapter.submitData(it)
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            adapter.refresh()
            Toast.makeText(requireContext(), "Data updated", Toast.LENGTH_SHORT)
                .show()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val SPACE_DECORATION = 20
    }
}