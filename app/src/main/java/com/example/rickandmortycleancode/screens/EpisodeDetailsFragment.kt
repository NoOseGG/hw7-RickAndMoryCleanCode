package com.example.rickandmortycleancode.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.rickandmortycleancode.databinding.FragmentEpisodeDetailsBinding
import com.example.rickandmortycleancode.viewmodel.ViewModelEpisodeDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EpisodeDetailsFragment : Fragment() {

    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: EpisodeDetailsFragmentArgs by navArgs()
    private val viewModel: ViewModelEpisodeDetails by viewModel{
        parametersOf(args.episodeNumber.toInt())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentEpisodeDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val episodeNumber = args.episodeNumber.toInt()

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.IO) {

            }
        }

        viewModel.episodeFlow.onEach {
            with(binding) {
                tvEpisodeNumber.text = it.episode
                tvAirDate.text = it.airDate
                tvCreated.text = it.created.substringBefore("T")
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}