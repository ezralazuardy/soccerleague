/*
 * Created by Ezra Lazuardy on 10/31/19, 11:55 AM
 * Copyright (c) 2019 . All rights reserved.
 * Last modified 10/31/19, 11:55 AM
 */

package com.soccer.league.view.detail

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.soccer.league.R
import com.soccer.league.model.list.Team
import com.soccer.league.viewmodel.detail.DetailViewModel
import org.jetbrains.anko.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity(), AnkoLogger {

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var loading: ProgressBar
    private lateinit var logoImage: ImageView
    private lateinit var venueImage: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var descriptionVenue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frameLayout {
            lparams {
                height = matchParent
                width = matchParent
            }
            scrollView {
                verticalLayout {
                    padding = dip(16)
                    logoImage = imageView().lparams {
                        topMargin = dip(8)
                        width = dip(100)
                        height = dip(100)
                        gravity = Gravity.CENTER
                    }
                    title = textView {
                        textSize = 20f
                        textColor = ContextCompat.getColor(context, android.R.color.black)
                        typeface = Typeface.DEFAULT_BOLD
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams {
                        topMargin = dip(12)
                        width = wrapContent
                        height = wrapContent
                        gravity = Gravity.CENTER
                    }
                    description = textView {
                        textSize = 18f
                        textColor = ContextCompat.getColor(context, android.R.color.black)
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams {
                        topMargin = dip(6)
                        width = wrapContent
                        height = wrapContent
                        gravity = Gravity.CENTER
                    }
                    venueImage = imageView().lparams {
                        topMargin = dip(34)
                        width = dip(300)
                        height = dip(200)
                        gravity = Gravity.CENTER
                    }
                    descriptionVenue = textView {
                        textSize = 18f
                        textColor = ContextCompat.getColor(context, android.R.color.black)
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams {
                        topMargin = dip(12)
                        width = wrapContent
                        height = wrapContent
                        gravity = Gravity.CENTER
                    }
                }.lparams {
                    height = wrapContent
                    width = matchParent
                }
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
        setUI()
        getData()
    }

    private fun setUI() {
        supportActionBar?.apply {
            title = null
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun getData() {
        (intent.getParcelableExtra("team") as Team?).let {
            if (it == null) {
                error { "${this::class.java.simpleName} is receiving null \"team\" data, finishing..." }
                finish()
            } else {
                observeViewModel(it)
            }
        }
    }

    private fun observeViewModel(cachedTeam: Team) {
        detailViewModel.teamId = cachedTeam.id
        detailViewModel.countryId = cachedTeam.country_id
        detailViewModel.venueId = cachedTeam.venue_id
        detailViewModel.seasonId = cachedTeam.current_season_id
        detailViewModel.country.observe(this, Observer { country ->
            detailViewModel.venue.observe(this, Observer { venue ->
                detailViewModel.season.observe(this, Observer { season ->
                    detailViewModel.leagueId = season.league_id
                    detailViewModel.league.observe(this, Observer { league ->
                        if (!detailViewModel.loaded) {
                            detailViewModel.loaded = true
                            hideLoading()
                        }
                        supportActionBar?.title = cachedTeam.name
                        Glide.with(this)
                            .load(cachedTeam.logo_path)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                            .placeholder(android.R.color.white)
                            .error(android.R.color.white)
                            .into(logoImage)
                        Glide.with(this)
                            .load(venue.image_path)
                            .apply(RequestOptions().transform(CenterCrop()).transform(RoundedCorners(12)))
                            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                            .placeholder(android.R.color.white)
                            .error(android.R.color.white)
                            .into(venueImage)
                        title.text = cachedTeam.name
                        description.text = getString(
                            R.string.activity_detail_description,
                            cachedTeam.name,
                            cachedTeam.founded,
                            country.name,
                            season.name,
                            league.name
                        )
                        descriptionVenue.text = getString(
                            R.string.activity_detail_description_venue,
                            venue.name,
                            venue.city,
                            venue.capacity
                        )
                    })
                })
            })
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
        if (detailViewModel.loaded) hideLoading() else showLoading()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) super.onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}