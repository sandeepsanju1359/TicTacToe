package com.example.tictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityTicTacToeExampleBinding

class TicTacToeExample : AppCompatActivity() {
    lateinit var binding: ActivityTicTacToeExampleBinding
    lateinit var pla1 : String
    lateinit var pla2 : String
    lateinit var mp : MediaPlayer
     var pc1 : Int = 0
     var pc2 : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Tic Tac Toe"

        val bundle:Bundle? =intent.extras
        val pl1 = bundle?.get("pl1")
        val pl2 = bundle?.get("pl2")
        binding.p1.text=pl1.toString()
        binding.p2.text=pl2.toString()

        pla2 = pl2.toString()
        pla1 = pl1.toString()

        binding.imageView2.isVisible = true
        binding.imageView.isVisible = true

        binding.txv.text="Lets Start!! ${pla1}'s Turn"

            binding.btn1.isVisible = true
            binding.btn2.isVisible = true
            binding.btn3.isVisible = true
            binding.btn4.isVisible = true
            binding.btn5.isVisible = true
            binding.btn6.isVisible = true
            binding.btn7.isVisible = true
            binding.btn8.isVisible = true
            binding.btn9.isVisible = true

        binding.rdl.isVisible=false
        binding.ldl.isVisible=false
        binding.thl.isVisible=false
        binding.bhl.isVisible=false
        binding.rvl.isVisible=false
        binding.lvl.isVisible=false
        binding.mvl.isVisible=false
        binding.mhl.isVisible=false
        mp = MediaPlayer.create(this ,R.raw.click);
        binding.restartBtn.visibility = View.INVISIBLE
        binding.btn1.setOnClickListener {
            selectedButton(binding.btn1)
            mp.start()
        }
        binding.btn2.setOnClickListener {
            selectedButton(binding.btn2)
            mp.start()
        }
        binding.btn3.setOnClickListener {
            selectedButton(binding.btn3)
            mp.start()
        }
        binding.btn4.setOnClickListener {
            selectedButton(binding.btn4)
            mp.start()
        }
        binding.btn5.setOnClickListener {
            selectedButton(binding.btn5)
            mp.start()
        }
        binding.btn6.setOnClickListener {
            selectedButton(binding.btn6)
            mp.start()
        }
        binding.btn7.setOnClickListener {
            selectedButton(binding.btn7)
            mp.start()
        }
        binding.btn8.setOnClickListener {
            selectedButton(binding.btn8)
            mp.start()
        }
        binding.btn9.setOnClickListener {
            selectedButton(binding.btn9)
            mp.start()
        }
        binding.restartBtn.setOnClickListener {
            restart()

        }

        binding.undoBtn.setOnClickListener {
            undo()
        }

      binding.undoBtn.isVisible=false
    }

    fun selectedButton(view:View){
        val selectedBtn = view as Button
        var  btnNum = 0
        when(selectedBtn.id){
            R.id.btn1 -> btnNum = 1
            R.id.btn2 -> btnNum = 2
            R.id.btn3 -> btnNum = 3
            R.id.btn4 -> btnNum = 4
            R.id.btn5 -> btnNum = 5
            R.id.btn6 -> btnNum = 6
            R.id.btn7 -> btnNum = 7
            R.id.btn8 -> btnNum = 8
            R.id.btn9 -> btnNum = 9
        }

        game(btnNum,selectedBtn)
    }

    var player = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun game(cell:Int,selectedBtn:Button){
        binding.restartBtn.visibility = View.INVISIBLE

        if (player == 1){
            selectedBtn.text = "O"
            selectedBtn.setBackgroundResource(R.drawable.btn_shadow)
            player1.add(cell)
            player =2
            binding.undoBtn.isVisible= true
            binding.txv.text="${pla2}'s Turn"
        }else{
            selectedBtn.text = "X"
            selectedBtn.setBackgroundResource(R.drawable.btn_shadow)
            player = 1
            binding.txv.text="${pla1}'s Turn"
            binding.undoBtn.isVisible= true
            player2.add(cell)

        }
        selectedBtn.isEnabled = false
        neutral()

        if (player1.contains(1)&& player1.contains(2) && player1.contains(3)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            disableButton()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn2.setBackgroundColor(Color.GREEN)
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.thl.isVisible=true
            binding.undoBtn.isVisible= false
            pc1++
            binding.txv.isVisible=false
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn2.setBackgroundColor(Color.GREEN)
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.thl.isVisible=true
            disableButton()
            binding.undoBtn.isVisible= false
            binding.txv.isVisible=false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn4.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn6.setBackgroundColor(Color.GREEN)
            binding.mhl.isVisible=true
            disableButton()
            binding.undoBtn.isVisible= false
            binding.txv.isVisible=false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn4.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn6.setBackgroundColor(Color.GREEN)
            binding.mhl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.btn8.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)
            binding.bhl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.btn8.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)

            binding.bhl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(1)&& player1.contains(4) && player1.contains(7)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn4.setBackgroundColor(Color.GREEN)
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.lvl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn4.setBackgroundColor(Color.GREEN)
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.lvl.isVisible=true
            disableButton()
            binding.txv.isVisible = false
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn2.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn8.setBackgroundColor(Color.GREEN)
            binding.mvl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            binding.txv.isVisible = false
            binding.btn2.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn8.setBackgroundColor(Color.GREEN)
            binding.mvl.isVisible=true
            val alertDialog = builder.create()
            alertDialog.show()
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.btn6.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)
            binding.rvl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.btn6.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)
            binding.rvl.isVisible=true
            alertDialog.show()
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.ldl.isVisible=true
            alertDialog.show()
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            binding.btn3.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn7.setBackgroundColor(Color.GREEN)
            binding.ldl.isVisible=true
            val alertDialog = builder.create()
            alertDialog.show()
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla1} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)
            binding.rdl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc1++
            binding.p1.text = pla1 +": ${pc1}"
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Horray!!")
            builder.setMessage("${pla2} Wins")
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
            binding.btn1.setBackgroundColor(Color.GREEN)
            binding.btn5.setBackgroundColor(Color.GREEN)
            binding.btn9.setBackgroundColor(Color.GREEN)
            binding.rdl.isVisible=true
            binding.txv.isVisible = false
            disableButton()
            binding.undoBtn.isVisible= false
            pc2++
            binding.p2.text = pla2 +": ${pc2}"
        }

    }
    fun restart(){
        binding.txv.isVisible=true
        if(player1.size > player2.size){
            binding.txv.text="${pla2}'s Turn"
        }
        else{
            binding.txv.text="${pla1}'s Turn"
        }
        player1.clear()
        player2.clear()


        binding.btn1.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn2.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn3.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn4.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn5.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn6.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn7.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn8.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn9.setBackgroundResource(R.drawable.btn_shadow)
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        binding.btn1.isEnabled = true
        binding.btn2.isEnabled = true
        binding.btn3.isEnabled = true
        binding.btn4.isEnabled = true
        binding.btn5.isEnabled = true
        binding.btn6.isEnabled = true
        binding.btn7.isEnabled = true
        binding.btn8.isEnabled = true
        binding.btn9.isEnabled = true

        binding.rdl.isVisible=false
        binding.ldl.isVisible=false
        binding.thl.isVisible=false
        binding.bhl.isVisible=false
        binding.rvl.isVisible=false
        binding.lvl.isVisible=false
        binding.mvl.isVisible=false
        binding.mhl.isVisible=false
    }

    fun neutral(){
        if (player1.size ==4 && player2.size ==4 ){
            disableButton()
        }else if (player1.size >4 || player2.size >4){

        }
    }

    fun undo(){
        if(player1.size>player2.size){
            val ub= player1.last()
            when(ub){
                1 -> {
                    binding.btn1.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(1)
                    player =1
                    binding.btn1.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn1.setBackgroundResource(R.drawable.btn_shadow)

                }
                2 -> {
                    binding.btn2.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(2)
                    player =1
                    binding.btn2.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn2.setBackgroundResource(R.drawable.btn_shadow)


                }
                3 -> {
                    binding.btn3.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(3)
                    player =1
                    binding.btn3.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn3.setBackgroundResource(R.drawable.btn_shadow)

                }
                4 -> {
                    binding.btn4.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(4)
                    player =1
                    binding.btn4.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn4.setBackgroundResource(R.drawable.btn_shadow)

                }
                5 -> {
                    binding.btn5.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(5)
                    player =1
                    binding.btn5.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn5.setBackgroundResource(R.drawable.btn_shadow)


                }
                6 -> {
                    binding.btn6.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(6)
                    player =1
                    binding.btn6.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn6.setBackgroundResource(R.drawable.btn_shadow)


                }
                7 -> {
                    binding.btn7.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(7)
                    player =1
                    binding.btn7.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn7.setBackgroundResource(R.drawable.btn_shadow)

                }
                8 -> {
                    binding.btn8.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(8)
                    player =1
                    binding.btn8.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn8.setBackgroundResource(R.drawable.btn_shadow)

                }
                9 -> {
                    binding.btn9.text = " "
                    binding.imageView2.isVisible=true
                    player1.remove(9)
                    player =1
                    binding.btn9.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla1}'s Turn"
                    binding.btn9.setBackgroundResource(R.drawable.btn_shadow)


                }

            }

        } else{
            val ub= player2.last()
            when(ub){
                1 -> {
                    binding.btn1.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(1)
                    player =2
                    binding.btn1.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn1.setBackgroundResource(R.drawable.btn_shadow)
                }
                2 -> {
                    binding.btn2.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(2)
                    player =2
                    binding.btn2.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn2.setBackgroundResource(R.drawable.btn_shadow)


                }
                3 -> {
                    binding.btn3.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(3)
                    player =2
                    binding.btn3.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn3.setBackgroundResource(R.drawable.btn_shadow)


                }
                4 -> {
                    binding.btn4.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(4)
                    player =2
                    binding.btn4.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn4.setBackgroundResource(R.drawable.btn_shadow)


                }
                5 -> {
                    binding.btn5.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(5)
                    player =2
                    binding.btn5.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn5.setBackgroundResource(R.drawable.btn_shadow)


                }
                6 -> {
                    binding.btn6.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(6)
                    player =2
                    binding.btn6.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn6.setBackgroundResource(R.drawable.btn_shadow)


                }
                7 -> {
                    binding.btn7.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(7)
                    player =2
                    binding.btn7.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn7.setBackgroundResource(R.drawable.btn_shadow)


                }
                8 -> {
                    binding.btn8.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(8)
                    player =2
                    binding.btn8.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn8.setBackgroundResource(R.drawable.btn_shadow)


                }
                9 -> {
                    binding.btn9.text = " "
                    binding.imageView.isVisible=true
                    player2.remove(9)
                    player =2
                    binding.btn9.isEnabled=true
                    binding.undoBtn.isVisible= false
                    binding.txv.text="${pla2}'s Turn"
                    binding.btn9.setBackgroundResource(R.drawable.btn_shadow)


                }

            }
        }
    }



    fun disableButton(){
        binding.btn1.isEnabled = false
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false
        binding.restartBtn.visibility = View.VISIBLE
    }

}