package com.example.application_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding = ActivityMainBinding.inflate(layoutInflater)


        binding.btnLogIn.setOnClickListener{

            val name = binding.Name.text.toString()
            val email = binding.Email.text.toString()
            if (name.isNotBlank() && email.isNotBlank()){
                val prefs = getSharedPreferences("credenciales",Context.MODE_PRIVATE)
                val editor = prefs.edit()

                editor.putString("name",name)
                editor.putString("email",email)
                editor.apply() //para guargar los datos

                val name2= prefs.getString("name",null)
                val email2 = prefs.getString("email",null)

                binding.showData.text = "Hola, $name2 \n Email : $email2 "

            }
        }


    }


}