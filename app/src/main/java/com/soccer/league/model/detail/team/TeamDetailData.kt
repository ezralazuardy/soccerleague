/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.team

data class TeamDetailData(
    val country_id: Int,
    val current_season_id: Int,
    val founded: Int,
    val id: Int,
    val legacy_id: Int,
    val logo_path: String,
    val name: String,
    val national_team: Boolean,
    val short_code: Any,
    val twitter: Any,
    val venue_id: Int
)