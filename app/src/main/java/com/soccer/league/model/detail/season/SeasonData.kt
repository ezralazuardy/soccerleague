/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.season

data class SeasonData(
    val current_round_id: Int,
    val current_stage_id: Int,
    val id: Int,
    val is_current_season: Boolean,
    val league_id: Int,
    val name: String
)