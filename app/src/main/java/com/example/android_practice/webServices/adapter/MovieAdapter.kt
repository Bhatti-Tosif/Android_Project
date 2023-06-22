package com.example.android_practice.webServices.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_practice.databinding.ItemMovieListBinding
import com.example.android_practice.webServices.model.MovieResult

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList = ArrayList<MovieResult>()
    fun setMovieList(movieList: List<MovieResult>) {
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }
    class MovieViewHolder(val binding: ItemMovieListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movieData: MovieResult) {
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500" + movieData.poster_path)
                .into(binding.movieImage)
            binding.movieName.text = movieData.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}