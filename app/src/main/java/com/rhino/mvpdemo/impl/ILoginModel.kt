package com.rhino.mvpdemo.impl

/**
 * @author LuoLin
 * @since Create on 2018/5/18.
 */
interface ILoginModel {

    interface IOnLoginListener {
        /**
         * Called when login success.
         */
        fun onLoginSuccess()

        /**
         * Called when login failed.
         *
         * @param errorNo the error no
         */
        fun onLoginFailed(errorNo: Int)
    }

    /**
     * Do login.
     *
     * @param username the username
     * @param password the password
     * @param listener the login listener
     */
    fun doLogin(username: String, password: String, listener: IOnLoginListener)

}