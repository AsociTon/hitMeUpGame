package com.example.hitmeupcheat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome_back.*

class welcomeBack : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_back)
        val intent=intent
        var a = intent.getIntExtra("score",0)
        if(a>0) {
            tag.text = "Your Hits:" + a
            button.text="PLAY AGAIN"

        }
    }


    fun gotoMain(view: View)
    {
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
}
