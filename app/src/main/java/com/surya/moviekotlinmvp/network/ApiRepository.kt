package com.surya.moviekotlinmvp.network

import java.net.URL

class ApiRepository {

    fun doRequest(url:String) : String{
        return URL(url).readText()
    }
}