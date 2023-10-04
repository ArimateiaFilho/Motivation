package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.config.Constants
import com.example.motivation.config.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            handleSave()
        }
//        supportActionBar?.hide()

        verifyUserName()
    }

    private fun verifyUserName() {
        var strHello = SecurityPreferences(this).getName(Constants.KEY.USER_NAME)
        if( strHello != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave(){
        val name = binding.editWhatsYourName.text.toString()

        if (name.isNotEmpty()){

            SecurityPreferences(this).save(Constants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, R.string.validation_mandatory_name,Toast.LENGTH_SHORT).show()
        }

    }

}