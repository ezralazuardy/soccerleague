/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:54 AM
 */

package com.soccer.league.di

import com.soccer.league.database.RemoteDatabase
import com.soccer.league.repository.SoccerLeagueRepository
import com.soccer.league.viewmodel.detail.DetailViewModel
import com.soccer.league.viewmodel.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { SoccerLeagueRepository(RemoteDatabase.remoteDao()) }

    viewModel { ListViewModel(get(), get()) }

    viewModel { DetailViewModel(get(), get()) }
}