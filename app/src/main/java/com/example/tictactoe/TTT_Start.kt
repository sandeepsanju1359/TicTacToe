package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityTttStartBinding

class TTT_Start : AppCompatActivity() {
    lateinit var binding:ActivityTttStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTttStartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener {
            gamestart()
        }
    }

    private fun gamestart() {
        val intent =Intent(this,TicTacToeExample::class.java)
        intent.putExtra("pl1",binding.player1et.text)
        intent.putExtra("pl2",binding.player2et.text)
        startActivity(intent)
    }
}