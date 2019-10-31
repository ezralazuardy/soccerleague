/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.team

data class Subscription(
    val ends_at: Any,
    val started_at: StartedAt,
    val trial_ends_at: Any
)