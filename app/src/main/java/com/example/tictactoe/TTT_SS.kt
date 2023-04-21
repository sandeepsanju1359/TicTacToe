package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class TTT_SS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ttt_ss)

        supportActionBar?.title = "Tic Tac Toe"

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this,TTT_Start::class.java)
            startActivity(i)
            finish()},5000)
    }
}