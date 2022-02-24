package com.agnext.githubaction.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agnext.githubaction.AppStates
import com.agnext.githubaction.R
import com.agnext.githubaction.databinding.ActivityLoginBinding
import com.agnext.githubaction.ui.home.HomeActivity
import com.agnext.githubaction.utils.AppPreferences
import com.agnext.githubaction.utils.IntentUtil
import com.agnext.githubaction.utils.ToastUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    private fun init() {
        binding.btLogin.setOnClickListener(this)

        /**1 Create instance of VM and Observing LD*/
        viewModel = ViewModelProvider(
            this,
            LoginVM.LoginViewModelFactory(LoginRepository("ApiClient", this))
        ).get(LoginVM::class.java)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { state ->
            when (state) {
                AppStates.LOGIN_SUCCESS -> {
                    storeUserData()
                    ToastUtil.showToast(this, viewModel.massage)
                    IntentUtil.startActivity(this, HomeActivity::class.java, true)
                }
                AppStates.LOGIN_ERROR -> {
                    ToastUtil.showToast(this, viewModel.massage)
                }
            }
        }

        // Observe the LiveData  for Reactive UI, passing in this activity as the LifecycleOwner and the observer.
        viewModel.loginState.observe(this, nameObserver)
    }

    /**Using coroutines to store data in share preference */
    private fun storeUserData() {
        GlobalScope.launch(Dispatchers.Main) {
            AppPreferences.setLoginStatus(this@LoginActivity, true,viewModel.response!!.access_token)
        }
    }

    /**Onclick*/
    override fun onClick(v: View?) {
        when (v) {
            binding.btLogin -> {
                validateUserInput(binding.etUser.text.toString(), binding.etPass.text.toString())
            }
        }
    }
    /**Data validation*/
    private fun validateUserInput(userName: String, password: String) {
        if (TextUtils.isEmpty(userName) || (TextUtils.isEmpty(password))) {
            ToastUtil.showToast(this, getString(R.string.fill_all))
        } else {
            viewModel.username = binding.etUser.text.toString()
            viewModel.password = binding.etPass.text.toString()
            viewModel.login()
        }
    }
}