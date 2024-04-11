package com.nels.master.androidpractices.data.location

import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.nels.master.androidpractices.domain.location.ILocation
import com.nels.master.androidpractices.domain.util.hasLocationPermitions
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import java.security.AccessControlContext
import javax.inject.Inject
import kotlin.coroutines.resume

class DefaultLocationTracker @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
     @ApplicationContext private val context: Context
) : ILocation {

    override suspend fun getCurrentLocation(): Location? {

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isProviderEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)


        if (!context.hasLocationPermitions() || !isProviderEnabled)
            return null

        return suspendCancellableCoroutine { cont ->
            fusedLocationProviderClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful)
                        cont.resume(result)
                    else
                        cont.resume(null)

                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(it)
                }
                addOnFailureListener {
                    cont.resume(null)
                }
                addOnCanceledListener {
                    cont.cancel()

                }
            }
        }


    }


}