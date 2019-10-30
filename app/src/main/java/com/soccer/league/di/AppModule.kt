/*
 * Created by Ezra Lazuardy on 10/30/19, 7:36 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 7:02 PM
 */

package com.soccer.league.di

import com.soccer.league.database.RemoteDatabase
import com.soccer.league.repository.SoccerLeagueRepository
import com.soccer.league.viewmodel.detail.ListViewModel
import com.soccer.league.viewmodel.list.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { SoccerLeagueRepository(RemoteDatabase.remoteDao()) }

    viewModel { ListViewModel(get(), get()) }

    viewModel { DetailViewModel(get(), get()) }
}