package com.example.android_practice.webServices.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android_practice.databinding.FragmentMusicBinding
import com.example.android_practice.webServices.adapter.MovieAdapter
import com.example.android_practice.webServices.viewModel.MovieViewModel


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(layoutInflater)
//        binding.btnNext.setOnClickListener {
//            Navigation.findNavController(binding.root).navigate(R.id.action_musicFragment_to_videoChatFragment)
//        }
//        binding.tvFrgChatting.setOnClickListener {
//            val navGraph = binding.root.findNavController().navInflater.inflate(R.navigation.nav_unsecure_graph)
////            val destination = navGraph.startDestinationId
////            navGraph.setStartDestination(destination)
//            binding.root.findNavController().graph = navGraph
//        }

        prepareRecyclerView()
        viewModel = ViewModelProvider(this) [MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner) { movieList ->
            movieAdapter.setMovieList(movieList)
        }
        return binding.root
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = movieAdapter
        }
    }
}