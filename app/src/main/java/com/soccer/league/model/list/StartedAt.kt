/*
 * Created by Ezra Lazuardy on 10/30/19, 8:42 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 7:36 PM
 */

package com.soccer.league.model.list

data class StartedAt(
    val date: String,
    val timezone: String,
    val timezone_type: Int
)