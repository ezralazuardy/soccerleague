/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:28 PM
 */

package com.soccer.league.model.list

data class Pagination(
    val count: Int,
    val current_page: Int,
    val links: List<Any>,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)