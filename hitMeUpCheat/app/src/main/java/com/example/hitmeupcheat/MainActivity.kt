package com.example.hitmeupcheat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score:Int=0;
    val handler :Handler = Handler()

    var runnable:Runnable = Runnable {  }

    var imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageArray = arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)

        hideImage()
        object : CountDownTimer(20000,1000) {
            override fun onFinish() {

                Toast.makeText(applicationContext,"Game Over!",Toast.LENGTH_LONG).show()
                timeLeft.text="Time left: 0"
                handler.removeCallbacks(runnable)
                for(i in imageArray)
                {
                    i.visibility=View.INVISIBLE
                }


                val intent=Intent(applicationContext,welcomeBack::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeft.text="Time left: "+millisUntilFinished/1000
            }


        }.start()
    }


    fun hideImage(){
        runnable = object:Runnable {
            override fun run() {

                for (i in imageArray) {
                    i.visibility = View.INVISIBLE
                }

                var random = Random()
                val index = random.nextInt(8-0)
                imageArray[index].visibility=View.VISIBLE

                handler.postDelayed(runnable,500)

            }

        }

        handler.post(runnable)
    }





    fun increaseScore(view:View)
    {
        score++;
        textView.text="Taps: "+score
    }
}
