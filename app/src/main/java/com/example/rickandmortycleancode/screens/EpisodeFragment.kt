package com.example.rickandmortycleancode.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortycleancode.adapter.EpisodeAdapter
import com.example.rickandmortycleancode.databinding.FragmentEpisodeBinding

class EpisodeFragment : Fragment() {

    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: EpisodeFragmentArgs by navArgs()
    private val adapter by lazy {
        EpisodeAdapter(requireContext()) {
            val action = EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentEpisodeBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listEpisode = args.characterEpisodes
        val list = listEpisode.map {
            it.substringAfterLast("/")
        }
        with(binding) {
            recyclerViewEpisodes.layoutManager = GridLayoutManager(requireContext(), 3)
            recyclerViewEpisodes.adapter = adapter
            adapter.submitList(list)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}