/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:28 PM
 */

package com.soccer.league.model.list

data class Meta(
    val pagination: Pagination,
    val plan: Plan,
    val sports: List<Sport>,
    val subscription: Subscription
)