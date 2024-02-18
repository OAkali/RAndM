package com.example.randm.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.randm.data.ViewModel
import com.example.randm.databinding.ActivityMainBinding
import com.example.randm.details.DetailsActivity
import com.example.randm.main.adapter.CartoonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }
    private val cartoonAdapter = CartoonAdapter(this::OnClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.e("ololo","hhhhgygyu")
        viewModel.getCharacters().observe(this) { characters ->
            cartoonAdapter.setList(characters)

            binding.rvRick.adapter=cartoonAdapter
        }
    }
    private fun OnClick(id: Int) {
        startActivity(Intent(this,DetailsActivity::class.java).apply {
            putExtra(KEY_ID,id)
        })
    }
    companion object{
        const val KEY_ID="ID_KEY"}
}