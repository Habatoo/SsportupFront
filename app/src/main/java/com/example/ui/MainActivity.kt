package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener(listener)
    }

    val listener = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.button -> {
                checkInfo()
            }
        }
    }

    private fun checkInfo() {
        val retrofit = RetrofitClientInstance.retrofitInstance
        val api = retrofit!!.create(InterfaceAPI::class.java)
        val call = api.checkUserInfo()
        call?.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if (response.isSuccessful) {
                    if (response.body()?.contains("User") == true) {
                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, "Invalid", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "ERROR", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Log.e("TAG", t.toString())
                t.printStackTrace()
            }
        })
    }
}