/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 7:36 PM
 */

package com.soccer.league.viewmodel.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.soccer.league.model.detail.TeamDetail
import com.soccer.league.repository.SoccerLeagueRepository
import com.soccer.league.viewmodel.base.OnLoadViewModel
import kotlinx.coroutines.Dispatchers

class DetailViewModel(
    application: Application,
    private val soccerLeagueRepository: SoccerLeagueRepository
) : AndroidViewModel(application), OnLoadViewModel {

    override var loaded = false
    val teamDetail: LiveData<TeamDetail> by lazy { getTeamDetailRemote() }
    var teamId: Int = 0

    private fun getTeamDetailRemote() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getTeamDetail(teamId))
    }
}