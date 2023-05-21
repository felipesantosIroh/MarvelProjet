package com.irohouse.chibatascomics.view.activity

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.irohouse.chibatascomics.databinding.ActivityMainBinding
import com.irohouse.chibatascomics.model.character.Character
import com.irohouse.chibatascomics.model.character.ResponseMarvelApiCharacters
import com.irohouse.chibatascomics.viewmodel.CharacterViewModel

class CharacterActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        viewModel.getCharacters()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.resultLiveData.observe(this){
            it?.let {
                configureAdapter(it)
            }
        }
    }

    private fun configureAdapter(it: ResponseMarvelApiCharacters) {
        val listCharacter: List<Character> = it.data.results
        val adapter = ArrayAdapter<Character>(this@CharacterActivity, R.layout.simple_list_item_1, listCharacter)
        binding.autoCompleteNameCharacter.setAdapter(adapter)

        binding.autoCompleteNameCharacter.setOnItemClickListener {_, _, position, _ ->
            val selectedItem: Character? = adapter.getItem(position)
            val intent = Intent(this@CharacterActivity, ListComicsActivity::class.java)

            binding.buttonListComics.setOnClickListener {
                intent.putExtra(CHARACTER_KEY, selectedItem)
                Log.i("ITEMSELECIONADO", selectedItem.toString())
                startActivity(intent)
            }
        }
    }

    companion object {
        const val CHARACTER_KEY = "character"
    }

}