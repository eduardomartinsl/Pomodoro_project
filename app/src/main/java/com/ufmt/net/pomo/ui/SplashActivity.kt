package com.ufmt.net.pomo.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ufmt.net.pomo.R

class SplashActivity : AppCompatActivity() {

    var handler = Handler()

    var waitTime = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var i = Intent(this, MainActivity::class.java)

        handler.postDelayed({ kotlin.run {
            startActivity(i)
        } }, waitTime)

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)

    }
}
