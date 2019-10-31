/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.venue

data class VenueData(
    val address: String,
    val capacity: Int,
    val city: String,
    val coordinates: Any,
    val id: Int,
    val image_path: String,
    val name: String,
    val surface: String
)