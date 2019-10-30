/*
 * Created by Ezra Lazuardy on 10/30/19, 8:42 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 8:11 PM
 */

package com.soccer.league.view.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.soccer.league.view.list.adapter.ListSoccerAdapter
import org.jetbrains.anko.padding
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class ListActivity : AppCompatActivity() {

    private val listSoccerAdapter: ListSoccerAdapter by lazy { ListSoccerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            recyclerView {
                padding = 16
                clipToPadding = false
                layoutManager = GridLayoutManager(this@ListActivity, 2)
                adapter = listSoccerAdapter

            }
        }
    }
}
