package com.irohouse.chibatascomics.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.irohouse.chibatascomics.R
import com.irohouse.chibatascomics.model.comic.Comic

class ListComicsAdapter (
    private val comics: List<Comic>,
    private val onClickComic: (comic: Comic) -> Unit
) : RecyclerView.Adapter<ListComicsAdapter.ComicViewHolder> (){

    class ComicViewHolder (itemView: View, val onClickComic: (comic: Comic) -> Unit) :
        RecyclerView.ViewHolder(itemView){
        private val textComicTitle: TextView = itemView.findViewById(R.id.textComicTitle)
        private val textDateModified: TextView = itemView.findViewById(R.id.textDateModified)
        private val textPageCountValue: TextView = itemView.findViewById(R.id.textPageCountValue)
        private val imgComicsThumbnailList: ImageView = itemView.findViewById(R.id.imgComicsThumbnailList)
        private var currentComic: Comic? = null

        fun bind(comic: Comic, onClickComic: (comic: Comic) -> Unit) {
            currentComic = comic

            textComicTitle.text = comic.title
            textDateModified.text = comic.modified
            textPageCountValue.text = comic.pageCount.toString()

            //add image with path by api
            imgComicsThumbnailList.setImageResource(R.drawable.ic_launcher_foreground)

            itemView.setOnClickListener{
                currentComic?.let(onClickComic)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_comics, parent, false)
        return ComicViewHolder(view, onClickComic)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(comics[position], onClickComic)
    }

    override fun getItemCount(): Int {
        return comics.size
    }


}