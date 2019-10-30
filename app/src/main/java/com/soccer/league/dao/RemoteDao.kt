/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 6:45 PM
 */

package com.soccer.league.dao

import com.soccer.league.model.detail.TeamDetail
import com.soccer.league.model.list.Teams
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteDao {

    @GET("teams/season/{season}")
    suspend fun getTeams(
        @Path("season") season: Int,
        @Query("api_token") apiToken: String
    ): Teams

    @GET("teams/{teamId}")
    suspend fun getTeamDetail(
        @Path("teamId") teamId: Int,
        @Query("api_token") apiToken: String
    ): TeamDetail
}