package com.nels.master.androidpractices.domain.location

import android.location.Location

interface ILocation {
    suspend fun getCurrentLocation():Location?
}