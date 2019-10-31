/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:55 AM
 */

package com.soccer.league.view.list

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.soccer.league.R
import com.soccer.league.model.list.Team
import com.soccer.league.view.detail.DetailActivity
import com.soccer.league.view.list.adapter.ListSoccerAdapter
import com.soccer.league.view.list.adapter.OnListSoccerItemClick
import com.soccer.league.viewmodel.list.ListViewModel
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.koin.android.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity(), OnListSoccerItemClick {

    private val listViewModel: ListViewModel by viewModel()
    private val listSoccerAdapter: ListSoccerAdapter by lazy { ListSoccerAdapter(this) }
    private lateinit var loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout {
            lparams {
                height = matchParent
                width = matchParent
            }
            recyclerView {
                padding = 16
                clipToPadding = false
                layoutManager = GridLayoutManager(this@ListActivity, 2)
                itemAnimator = SlideInUpAnimator()
                adapter = listSoccerAdapter
                listSoccerAdapter.notifyDataSetChanged()
                setHasFixedSize(true)
            }.lparams {
                height = matchParent
                width = matchParent
            }
            loading = progressBar {
                id = R.id.list_activity_soccer_loading
            }.lparams {
                height = wrapContent
                width = wrapContent
                gravity = Gravity.CENTER
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        listViewModel.getTeams.observe(this, Observer {
            if (!listViewModel.loaded) {
                listViewModel.loaded = true
                hideLoading()
            }
            listSoccerAdapter.setData(it)
        })
    }

    private fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        if (listViewModel.loaded) hideLoading() else showLoading()
    }

    override fun onBackPressed() {
        alert(resources.getString(R.string.dialog_confirm_exit_app)) {
            yesButton { super.onBackPressed() }
            noButton { }
        }.show()
    }

    override fun onItemClick(team: Team) {
        startActivity<DetailActivity>("team" to team)
    }
}
