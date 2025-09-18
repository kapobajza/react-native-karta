package com.karta

import androidx.annotation.Keep
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.facebook.proguard.annotations.DoNotStrip
import com.facebook.react.uimanager.ThemedReactContext
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.margelo.nitro.karta.HybridMapViewSpec
import com.margelo.nitro.karta.Variant_MapViewChildren_Array_MapViewChildren_

class ViewWithChildrenImpl(context: ThemedReactContext, onMapReadyCallback: OnMapReadyCallback) :
    MapView(context),
    DefaultLifecycleObserver {
    val context = context
    val onMapReadyCallback = onMapReadyCallback


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        context.currentActivity?.let { activity ->
            if (activity is LifecycleOwner) {
                activity.lifecycle.addObserver(this)
            }
        }

        super<MapView>.onCreate(null)
        super<MapView>.onStart()
        super<MapView>.onResume()

        super<MapView>.getMapAsync(onMapReadyCallback)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        super<MapView>.onPause()
        super<MapView>.onStop()
        context.currentActivity?.let { activity ->
            if (activity is LifecycleOwner) {
                activity.lifecycle.removeObserver(this)
            }
        }
    }


    override fun onStart(owner: LifecycleOwner) {
        super<MapView>.onStart()
    }

    override fun onResume(owner: LifecycleOwner) {
        super<MapView>.onResume()
    }

    override fun onPause(owner: LifecycleOwner) {
        super<MapView>.onPause()
    }

    override fun onStop(owner: LifecycleOwner) {
        super<MapView>.onStop()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super<MapView>.onDestroy()
    }

    override fun onCreate(owner: LifecycleOwner) {
        super<MapView>.onCreate(null)
    }
}

@Keep
@DoNotStrip
class HybridMapView(context: ThemedReactContext) : HybridMapViewSpec(), OnMapReadyCallback {
    var googleMap: GoogleMap? = null
    override val view = ViewWithChildrenImpl(context, this)

    private var _latitude: Double = 43.6532
    override var latitude: Double
        get() = _latitude
        set(value) {
            _latitude = value
            updateCamera()
        }

    private var _longitude: Double = -79.3832
    override var longitude: Double
        get() = _longitude
        set(value) {
            _longitude = value
            updateCamera()
        }

    private var _zoom: Double = 17.0
    override var zoom: Double
        get() = _zoom
        set(value) {
            _zoom = value
            updateCamera()
        }

    private var _children: Variant_MapViewChildren_Array_MapViewChildren_? = null
    override var children: Variant_MapViewChildren_Array_MapViewChildren_?
        get() = null
        set(value) {
            _children = value
            value?.let { updateMarkers(it) }
        }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        updateCamera()
        _children?.let {
            updateMarkers(it)
        }
    }

    private fun updateCamera() {
        googleMap?.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(_latitude, _longitude),
                zoom.toFloat()
            )
        )
    }

    private fun updateMarkers(mapChildVariant: Variant_MapViewChildren_Array_MapViewChildren_?) {
        googleMap?.clear()

        mapChildVariant?.let { mapChild ->
            if (mapChild is Variant_MapViewChildren_Array_MapViewChildren_.First) {
                googleMap?.addMarker(MarkerOptions().position(
                    LatLng(
                        mapChild.value.props.latitude,
                        mapChild.value.props.longitude
                    )
                ))
            }

            if (mapChild is Variant_MapViewChildren_Array_MapViewChildren_.Second) {
                for (child in mapChild.value) {
                    googleMap?.addMarker(
                        MarkerOptions().position(
                            LatLng(
                                child.props.latitude,
                                child.props.longitude
                            )
                        )
                    )
                }
            }
        }
    }
}