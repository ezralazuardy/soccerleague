/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:43 PM
 */

package com.soccer.league.model.detail

data class Meta(
    val plan: Plan,
    val sports: List<Sport>,
    val subscription: Subscription
)