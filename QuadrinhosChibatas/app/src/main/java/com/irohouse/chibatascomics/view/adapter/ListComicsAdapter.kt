package com.irohouse.chibatascomics.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irohouse.chibatascomics.databinding.ListComicsBinding
import com.irohouse.chibatascomics.model.comic.Comic

class ListComicsAdapter (
    private val comics: List<Comic>,
    private val onClickComic: (comic: Comic) -> Unit
) : RecyclerView.Adapter<ListComicsAdapter.ComicViewHolder> (){
    class ComicViewHolder(private val binding: ListComicsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comic: Comic, onClickComic: (comic: Comic) -> Unit) = with(binding) {
            textComicTitle.text = comic.title
            textDateModified.text = comic.modified
            textPageCountValue.text = comic.pageCount.toString()
            itemView.setOnClickListener{
                onClickComic(comic)
            }
            Glide.with(itemView)
                .load(comic.thumbnail.fullPath())
                .into(imgComicsThumbnailList)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComicViewHolder {
        val binding = ListComicsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(comics[position], onClickComic)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

}