/*
 * Created by Ezra Lazuardy on 10/30/19, 8:42 PM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/30/19, 8:42 PM
 */

package com.soccer.league.view.list.adapter

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.soccer.league.R
import com.soccer.league.model.list.Team
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ListSoccerAdapter : RecyclerView.Adapter<ListSoccerAdapter.ViewHolder>() {

    private val data = mutableListOf<Team>()

    fun setData(data: List<Team>) {
        this.data.clear()
        this.data.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(UI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    inner class UI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View =
            with(ui) {
                cardView {
                    lparams {
                        width = matchParent
                        height = wrapContent
                        margin = dip(8)
                        padding = dip(16)
                    }
                    verticalLayout {
                        imageView {
                            id = R.id.list_soccer_card_image
                        }.lparams {
                            width = dip(75)
                            height = dip(75)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            id = R.id.list_soccer_card_title
                        }.lparams {
                            gravity = Gravity.CENTER
                        }
                    }
                }
            }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(team: Team) {
            Glide.with(view.context)
                .load(team.logo_path)
                .into(view.find(R.id.list_soccer_card_image) as ImageView)
            (view.find(R.id.list_soccer_card_title) as TextView).text = team.name
        }
    }
}