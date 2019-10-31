/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.model.detail.team

data class Meta(
    val plan: Plan,
    val sports: List<Sport>,
    val subscription: Subscription
)