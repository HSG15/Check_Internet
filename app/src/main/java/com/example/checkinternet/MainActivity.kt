package com.example.checkinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val check: Button = findViewById(R.id.btn_check)
        internetIsAvailable()
        check.setOnClickListener {
            internetIsAvailable()
        }
    }

    private fun internetIsAvailable() {
        val checkAnimOnline = findViewById<LottieAnimationView>(R.id.online)
        val checkAnimOffline = findViewById<LottieAnimationView>(R.id.offline)

        if (Constants.isNetworkAvailable(this)) {
            checkAnimOnline.animate()
            checkAnimOnline.playAnimation()
            checkAnimOnline.visibility = View.VISIBLE
            checkAnimOffline.visibility = View.GONE
        } else {
            checkAnimOffline.animate()
            checkAnimOffline.playAnimation()
            checkAnimOnline.visibility = View.GONE
            checkAnimOffline.visibility = View.VISIBLE
        }
    }
}