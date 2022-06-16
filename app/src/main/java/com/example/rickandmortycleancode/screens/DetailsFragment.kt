package com.example.rickandmortycleancode.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.rickandmortycleancode.R
import com.example.rickandmortycleancode.databinding.FragmentDetailsBinding
import com.example.rickandmortycleancode.viewmodel.ViewModelDetailsFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: ViewModelDetailsFragment by viewModel{
        parametersOf(args.characterId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDetailsBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.characterId
        var episodes: Array<String> = emptyArray()
        var characterName = ""

        viewModel.characterFlow.onEach { character ->
            with(binding) {
                imgAvatarDetails.load(character.image)
                name.text = character.name
                status.text = getString(R.string.status, character.status)
                species.text = getString(R.string.species, character.species)
                type.text = getString(R.string.type, character.type)
                gender.text = getString(R.string.gender, character.gender)
            }
            episodes = character.episode.toTypedArray()
            characterName = character.name
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.buttonEpisodes.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToEpisodeFragment(
                characterName,
                episodes
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}