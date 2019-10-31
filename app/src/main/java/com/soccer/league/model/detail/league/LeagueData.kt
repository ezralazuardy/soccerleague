/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.league

data class LeagueData(
    val country_id: Int,
    val coverage: Coverage,
    val current_round_id: Int,
    val current_season_id: Int,
    val current_stage_id: Int,
    val id: Int,
    val is_cup: Boolean,
    val legacy_id: Int,
    val live_standings: Boolean,
    val name: String
)