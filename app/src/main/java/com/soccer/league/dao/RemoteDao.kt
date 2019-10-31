/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.dao

import com.soccer.league.model.detail.country.Country
import com.soccer.league.model.detail.league.League
import com.soccer.league.model.detail.season.Season
import com.soccer.league.model.detail.venue.Venue
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

    @GET("countries/{countryId}")
    suspend fun getCountry(
        @Path("countryId") countryId: Int,
        @Query("api_token") apiToken: String
    ): Country

    @GET("venues/{venueId}")
    suspend fun getVenue(
        @Path("venueId") venueId: Int,
        @Query("api_token") apiToken: String
    ): Venue

    @GET("seasons/{seasonId}")
    suspend fun getSeason(
        @Path("seasonId") seasonId: Int,
        @Query("api_token") apiToken: String
    ): Season

    @GET("leagues/{leagueId}")
    suspend fun getLeague(
        @Path("leagueId") leagueId: Int,
        @Query("api_token") apiToken: String
    ): League
}