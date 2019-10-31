/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.country

data class Extra(
    val continent: String,
    val fifa: String,
    val flag: String,
    val iso: String,
    val latitude: String,
    val longitude: String,
    val sub_region: String,
    val world_region: String
)