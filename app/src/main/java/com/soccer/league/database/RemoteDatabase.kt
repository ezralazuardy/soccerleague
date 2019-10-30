/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:49 PM
 */

package com.soccer.league.database

import com.soccer.league.api.Retrofit
import com.soccer.league.config.AppConfig
import com.soccer.league.dao.RemoteDao

object RemoteDatabase {

    fun remoteDao(): RemoteDao =
        Retrofit.getClient(AppConfig.SPORTMONKS_API_BASE_URL).create(RemoteDao::class.java)
}