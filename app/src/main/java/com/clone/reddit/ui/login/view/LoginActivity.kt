package com.clone.reddit.ui.login.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clone.reddit.MainActivity
import com.clone.reddit.R
import com.clone.reddit.ui.login.presenter.LoginPresenter
import com.clone.reddit.util.PreferenceManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    lateinit var loginPresenter: LoginPresenter
    lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferenceManager = PreferenceManager.getPreferences(this);

        val modhash = preferenceManager.getStoredString("modhash")

        if(modhash != ""){
            startActivity(Intent(this, MainActivity::class.java))
        }

        loginPresenter =  LoginPresenter.getPresenter()
        loginButton.setOnClickListener {
            CoroutineScope(Default).launch {
                loginPresenter.login(preferenceManager::storeString, ::navigateToMainActivity)
            }
         }

    }

    fun navigateToMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
