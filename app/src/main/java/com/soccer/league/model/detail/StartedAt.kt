/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:43 PM
 */

package com.soccer.league.model.detail

data class StartedAt(
    val date: String,
    val timezone: String,
    val timezone_type: Int
)