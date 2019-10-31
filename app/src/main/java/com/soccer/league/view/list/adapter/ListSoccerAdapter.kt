/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:55 AM
 */

package com.soccer.league.view.list.adapter

import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.soccer.league.R
import com.soccer.league.model.list.Team
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListSoccerAdapter(
    private val onListSoccerItemClick: OnListSoccerItemClick
) : RecyclerView.Adapter<ListSoccerAdapter.ViewHolder>() {

    private val data = mutableListOf<Team>()

    fun setData(data: List<Team>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(UI().createView(AnkoContext.create(parent.context, parent)), onListSoccerItemClick)

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
                    }
                    verticalLayout {
                        id = R.id.list_activity_soccer_item_card
                        isClickable = true
                        isFocusable = true
                        padding = dip(16)
                        this.addRipple()
                        imageView {
                            id = R.id.list_activity_soccer_item_card_image
                        }.lparams {
                            width = dip(70)
                            height = dip(70)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            id = R.id.list_activity_soccer_item_card_title
                            textSize = 18f
                            textColor = ContextCompat.getColor(context, android.R.color.black)
                            typeface = Typeface.DEFAULT_BOLD
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            topMargin = dip(12)
                            width = wrapContent
                            height = wrapContent
                            gravity = Gravity.CENTER
                        }
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                    }
                }
            }

        private fun View.addRipple() = with(TypedValue()) {
            context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
            setBackgroundResource(resourceId)
        }
    }

    inner class ViewHolder(
        private val view: View,
        private val onListSoccerItemClick: OnListSoccerItemClick
    ) : RecyclerView.ViewHolder(view) {

        fun bind(team: Team) {
            Glide.with(view.context)
                .load(team.logo_path)
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(android.R.color.white)
                .error(android.R.color.white)
                .into(view.find(R.id.list_activity_soccer_item_card_image) as ImageView)
            (view.find(R.id.list_activity_soccer_item_card_title) as TextView).text = team.name
            (view.find(R.id.list_activity_soccer_item_card) as LinearLayout).onClick {
                onListSoccerItemClick.onItemClick(
                    team
                )
            }
        }
    }
}