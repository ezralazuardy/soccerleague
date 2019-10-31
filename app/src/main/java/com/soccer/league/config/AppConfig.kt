/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.config

import com.soccer.league.BuildConfig

object AppConfig {

    const val SPORTMONKS_API_TOKEN: String = BuildConfig.SPORTMONKS_API_TOKEN
    const val SPORTMONKS_API_BASE_URL: String = "https://soccer.sportmonks.com/api/v2.0/"
    const val SPORTMONKS_DEFAULT_SEASON_ID = 16222
}