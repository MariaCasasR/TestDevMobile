package com.example.testtimetonic

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.testtimetonic.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.*
import retrofit2.http.*

class MainActivity : AppCompatActivity() {
    private val urlBase = "https://timetonic.com/"
    private lateinit var binding: ActivityMainBinding
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var service: PostApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = binding.username
        password = binding.password
        loginButton = binding.loginButton

        loginButton.setOnClickListener {
            val req = "createOauthkey"
            val login = username.text.toString()
            val pwd = password.text.toString()
            val appkey = "iTry-1i6a-mEHN-p6eB-2ftc-zcua-IAq8"
            getUserPost(req, login, pwd, appkey)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PostApiService::class.java)
    }

    private fun getUserPost(req: String, login: String, pwd: String, appkey: String) {
        lifecycleScope.launch {
            try {
                val response = service.getUserPost(req, login, pwd, appkey)
                handleApiResponse(response)
            } catch (e: Exception) {
                showToast("Error ${e}" )
                Log.d("TAG", "Error message: $e")
            }
        }
    }

    private fun handleApiResponse(response: ApiResponse) {
        Log.d("JSON Response", response.toString())
        if (response.status == "ok") {
            showToast("Login Successful! OAuth Key: ${response.oauthkey}")
        } else {
            showToast("Login Failed! Error: ${response.error}")
        }
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}




