/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.list

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val country_id: Int,
    val current_season_id: Int,
    val founded: Int,
    val id: Int,
    val legacy_id: Int,
    val logo_path: String,
    val name: String,
    val national_team: Boolean,
    val short_code: String?,
    val twitter: String?,
    val venue_id: Int
) : Parcelable