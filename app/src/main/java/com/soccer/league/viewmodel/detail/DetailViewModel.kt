/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.viewmodel.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.soccer.league.model.detail.country.CountryData
import com.soccer.league.model.detail.league.LeagueData
import com.soccer.league.model.detail.season.SeasonData
import com.soccer.league.model.detail.venue.VenueData
import com.soccer.league.repository.SoccerLeagueRepository
import com.soccer.league.viewmodel.base.OnLoadViewModel
import kotlinx.coroutines.Dispatchers

class DetailViewModel(
    application: Application,
    private val soccerLeagueRepository: SoccerLeagueRepository
) : AndroidViewModel(application), OnLoadViewModel {

    override var loaded = false
    val country: LiveData<CountryData> by lazy { getCountryData() }
    val venue: LiveData<VenueData> by lazy { getVenueData() }
    val season: LiveData<SeasonData> by lazy { getSeasonData() }
    val league: LiveData<LeagueData> by lazy { getLeagueData() }
    var teamId = 0
    var countryId = 0
    var venueId = 0
    var seasonId = 0
    var leagueId = 0

    private fun getCountryData() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getCountry(countryId))
    }

    private fun getVenueData() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getVenue(venueId))
    }

    private fun getSeasonData() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getSeason(seasonId))
    }

    private fun getLeagueData() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getLeague(leagueId))
    }
}