package com.rhino.mvpdemo.impl

/**
 * @author LuoLin
 * @since Create on 2018/5/18.
 */
interface ILoginPresenter {

    /**
     * Do login.
     *
     * @param username the username
     * @param password the password
     */
    fun doLogin(username: String, password: String)

}