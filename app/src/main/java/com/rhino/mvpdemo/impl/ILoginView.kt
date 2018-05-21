package com.rhino.mvpdemo.impl

/**
 * @author LuoLin
 * @since Create on 2018/5/18.
 */
interface ILoginView {

    /**
     * Called when login has been started.
     */
    fun onStartLogin()

    /**
     * Called when login success.
     */
    fun onLoginSuccess()

    /**
     * Called when login failed.
     *
     * @param errorNo the error no
     */
    fun onLoginFail(errorNo: Int)
    
}