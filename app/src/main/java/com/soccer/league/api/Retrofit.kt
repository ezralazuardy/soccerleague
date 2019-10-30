/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:19 PM
 */

package com.soccer.league.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    fun getClient(baseUrl: String = ""): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}