package com.rhino.mvpdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.rhino.mvpdemo.databinding.ActivityLoginBinding
import com.rhino.mvpdemo.impl.ILoginModel
import com.rhino.mvpdemo.impl.ILoginPresenter
import com.rhino.mvpdemo.impl.ILoginView

/**
 * @author LuoLin
 * @since Create on 2018/5/18.
 */
class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mPresenter: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)

        mPresenter = LoginPresenterImpl(this, LoginModelImpl())
        mBinding.emailSignInButton.setOnClickListener {
            val username: String = mBinding.email.text.toString()
            val password: String = mBinding.password.text.toString()
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                mPresenter.doLogin(username, password)
            } else {
                showToast("账号和密码不能为空")
            }
        }
    }

    override fun onStartLogin() {
        mBinding.loginProgress.visibility = View.VISIBLE
    }

    override fun onLoginSuccess() {
        mBinding.loginProgress.visibility = View.GONE
        showToast("登录成功")
    }

    override fun onLoginFail(errorNo: Int) {
        mBinding.loginProgress.visibility = View.GONE
        showToast("登录失败：" + errorNo)
    }





    class LoginModelImpl : ILoginModel {

        override fun doLogin(username: String, password: String, listener: ILoginModel.IOnLoginListener) {
            Handler().postDelayed({
                if ("1" == username && "1" == password) {
                    listener.onLoginSuccess()
                } else {
                    listener.onLoginFailed(1)
                }
            }, 2000)
        }
    }

    class LoginPresenterImpl(private var mLoginView: ILoginView, private var mLoginModel: ILoginModel) : ILoginPresenter, ILoginModel.IOnLoginListener {

        override fun doLogin(username: String, password: String) {
            mLoginView.onStartLogin()
            mLoginModel.doLogin(username, password, this)
        }

        override fun onLoginSuccess() {
            mLoginView.onLoginSuccess()
        }

        override fun onLoginFailed(errorNo: Int) {
            mLoginView.onLoginFail(errorNo)
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }


}