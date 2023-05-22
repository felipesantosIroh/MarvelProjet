package com.irohouse.chibatascomics.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.irohouse.chibatascomics.databinding.ActivityListComicsBinding
import com.irohouse.chibatascomics.model.character.Character
import com.irohouse.chibatascomics.model.comic.Comic
import com.irohouse.chibatascomics.model.comic.ResponseMarvelApiComics
import com.irohouse.chibatascomics.view.activity.CharacterActivity.Companion.CHARACTER_KEY
import com.irohouse.chibatascomics.view.adapter.ListComicsAdapter
import com.irohouse.chibatascomics.viewmodel.ListComicsViewModel

class ListComicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListComicsBinding
    private lateinit var viewModel: ListComicsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "List Comics"
        initComponents()
    }

    private fun initComponents() {
        viewModel = ViewModelProvider(this)[ListComicsViewModel::class.java]
        val character = intent.getParcelableExtra<Character>(CHARACTER_KEY)
        if (character != null) {
            viewModel.getComics(character.id)
            setupObservers()
        } else {
            Log.e("ERRO CHAR", "Character null")
        }
    }

    private fun setupObservers() {
        viewModel.resultLiveData.observe(this){
            it?.let {
                configureAdapter(it)
            }
        }
    }

    private fun configureAdapter(it: ResponseMarvelApiComics) {
        binding.recycleListComics.apply {
            layoutManager = LinearLayoutManager(this@ListComicsActivity)
            adapter = ListComicsAdapter(it.data.results){
                onClickComic(it)
            }
        }
    }

    private fun onClickComic(comic: Comic) {
        val intent = Intent(this@ListComicsActivity, ComicsDetailActivity::class.java)
        intent.putExtra(COMIC_KEY, comic)
        startActivity(intent)
    }

    companion object {
        const val COMIC_KEY = "comic"
    }

}