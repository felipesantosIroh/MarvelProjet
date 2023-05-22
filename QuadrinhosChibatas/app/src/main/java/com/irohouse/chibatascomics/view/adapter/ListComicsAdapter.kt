package com.irohouse.chibatascomics.view.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irohouse.chibatascomics.databinding.ListComicsBinding
import com.irohouse.chibatascomics.model.comic.Comic
import com.irohouse.chibatascomics.util.Constants
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class ListComicsAdapter(
    private val comics: List<Comic>,
    private val onClickComic: (comic: Comic) -> Unit
) : RecyclerView.Adapter<ListComicsAdapter.ComicViewHolder>() {
    class ComicViewHolder(private val binding: ListComicsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comic: Comic, onClickComic: (comic: Comic) -> Unit) = with(binding) {

            val date = comic.modified.substring(0, comic.modified.indexOf("T"))
            val dateFormated = buildString {
                append(date.substring(8, date.length))  //dd
                append("/")
                append(date.substring(5, 7))            //MM
                append("/")
                append(date.substring(0, 4))            //yyyy
            }

            textComicTitle.text = comic.title
            textDateModified.text = dateFormated
            textPageCountValue.text = comic.pageCount.toString()
            itemView.setOnClickListener {
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