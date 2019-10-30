/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:28 PM
 */

package com.soccer.league.model.list

data class Subscription(
    val ends_at: Any,
    val started_at: StartedAt,
    val trial_ends_at: Any
)