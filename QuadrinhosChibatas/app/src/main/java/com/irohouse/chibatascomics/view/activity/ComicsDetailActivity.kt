package com.irohouse.chibatascomics.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.irohouse.chibatascomics.databinding.ActivityComicsDetailBinding
import com.irohouse.chibatascomics.model.comic.Comic
import com.irohouse.chibatascomics.view.activity.ListComicsActivity.Companion.COMIC_KEY
import com.irohouse.chibatascomics.view.adapter.ListCreatorAdapter

class ComicsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        //viewModel = ViewModelProvider(this).get(ComicsDetailViewModel::class.java)
        val comic = intent.getParcelableExtra<Comic>(COMIC_KEY)
        if (comic != null) {
            configureAdapter(comic)
        }
        comic?.let {
            bindValues(comic)
        }
    }

    private fun configureAdapter(comic: Comic) {
        binding.recycleListCreator.apply {
            layoutManager = LinearLayoutManager(this@ComicsDetailActivity)
            adapter = ListCreatorAdapter(comic.creators.items)
        }
    }

    private fun bindValues(it: Comic) {
        binding.apply {
            Glide.with(this@ComicsDetailActivity)
                .load(it.thumbnail.fullPath())
                .into(imgComicsThumbnail)
        }
    }

}