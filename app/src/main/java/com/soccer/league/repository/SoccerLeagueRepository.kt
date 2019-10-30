/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:51 PM
 */

package com.soccer.league.repository

import com.soccer.league.config.AppConfig
import com.soccer.league.dao.RemoteDao

class SoccerLeagueRepository(private val remoteDao: RemoteDao) {

    suspend fun getTeams(season: Int = 1, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getTeams(season, apiToken).data.filter { it.logo_path.isNotEmpty() }

    suspend fun getTeamDetail(teamId: Int, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getTeamDetail(teamId, apiToken)
}