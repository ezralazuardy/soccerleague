/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:55 AM
 */

package com.soccer.league.repository

import com.soccer.league.config.AppConfig
import com.soccer.league.dao.RemoteDao

class SoccerLeagueRepository(private val remoteDao: RemoteDao) {

    suspend fun getTeams(
        season: Int = AppConfig.SPORTMONKS_DEFAULT_SEASON_ID,
        apiToken: String = AppConfig.SPORTMONKS_API_TOKEN
    ) =
        remoteDao.getTeams(season, apiToken).data.filter { it.logo_path.isNotEmpty() }

    suspend fun getCountry(countryId: Int, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getCountry(countryId, apiToken).data

    suspend fun getVenue(venueId: Int, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getVenue(venueId, apiToken).data

    suspend fun getSeason(seasonId: Int, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getSeason(seasonId, apiToken).data

    suspend fun getLeague(leagueId: Int, apiToken: String = AppConfig.SPORTMONKS_API_TOKEN) =
        remoteDao.getLeague(leagueId, apiToken).data
}