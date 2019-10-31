/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.viewmodel.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.soccer.league.model.list.Team
import com.soccer.league.repository.SoccerLeagueRepository
import com.soccer.league.viewmodel.base.OnLoadViewModel
import kotlinx.coroutines.Dispatchers

class ListViewModel(
    application: Application,
    private val soccerLeagueRepository: SoccerLeagueRepository
) : AndroidViewModel(application), OnLoadViewModel {

    override var loaded = false
    val getTeams: LiveData<List<Team>> by lazy { getTeams() }

    private fun getTeams() = liveData(Dispatchers.IO) {
        emit(soccerLeagueRepository.getTeams())
    }
}