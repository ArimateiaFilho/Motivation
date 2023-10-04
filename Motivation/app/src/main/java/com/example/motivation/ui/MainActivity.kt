package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.config.Constants
import com.example.motivation.config.SecurityPreferences
import com.example.motivation.data.Mock
import com.example.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var category = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        imageAllInclusive()
        randomPhrase(category)

        binding.imageAllInclusive.setOnClickListener {
            imageAllInclusive()
        }

        binding.imageHappy.setOnClickListener {
            imageHappy()
        }

        binding.imageSunny.setOnClickListener {
            imageSunny()
        }

        binding.buttonNewPhrase.setOnClickListener {
            randomPhrase(category)
        }
    }

    private fun randomPhrase(id: Int){
        binding.textMotivation.text = Mock().getPhrase(id, Locale.getDefault().language)
    }

    private fun imageAllInclusive() {
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        category = Constants.FILTER.ALL_INCLUSIVE
    }

    private fun imageHappy() {
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        category = Constants.FILTER.HAPPY
    }

    private fun imageSunny() {
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
        category = Constants.FILTER.SUNNY
    }

    private fun handleUserName() {
        var strHello = SecurityPreferences(this).getName(Constants.KEY.USER_NAME)
        var hello = getString(R.string.hello)
        binding.textHello.text = "$hello, $strHello!"
    }


}