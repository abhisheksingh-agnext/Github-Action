package com.agnext.githubaction.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.agnext.githubaction.utils.IntentUtil
import com.agnext.githubaction.utils.SharePreData
import com.agnext.githubaction.R
import com.agnext.githubaction.ui.home.HomeActivity
import com.agnext.githubaction.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        //Moving to Home screen
        Handler(Looper.getMainLooper()).postDelayed({
            if (SharePreData.getLoginStatus(this))
                IntentUtil.startActivity(this, HomeActivity::class.java, true)
            else
                IntentUtil.startActivity(this, LoginActivity::class.java, true)
        }, 3000)
    }
}