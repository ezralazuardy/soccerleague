/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:55 AM
 */

package com.soccer.league.view.list.adapter

import com.soccer.league.model.list.Team

interface OnListSoccerItemClick {

    fun onItemClick(team: Team)
}