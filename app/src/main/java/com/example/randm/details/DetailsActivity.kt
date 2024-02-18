package com.example.randm.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.randm.data.ViewModel
import com.example.randm.databinding.ActivityDetailsBinding
import  com.example.randm.data.model.Character
import com.example.randm.main.MainActivity
import dagger.hilt.android.HiltAndroidApp


class DetailsActivity : AppCompatActivity() {
    private val binding: ActivityDetailsBinding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)

    }
    private val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val id = intent.getIntExtra(MainActivity.KEY_ID, 0)
        viewModel.getData(id).observe(this) {
            setCharacterData(it)
        }

    }

    private fun setCharacterData(it: Character) = with(binding) {
        tvName.text = it.name
        tvStatus.text = it.status
        Glide.with(ivChar).load(it.imege).into(ivChar)
        tvHuman.text = it.species
    }
}