package com.karta

import android.view.View
import androidx.annotation.Keep
import com.facebook.proguard.annotations.DoNotStrip

import com.facebook.react.uimanager.ThemedReactContext
import com.margelo.nitro.karta.HybridMapMarkerSpec

@Keep
@DoNotStrip
class HybridMapMarker(val context: ThemedReactContext): HybridMapMarkerSpec() {
    override var latitude: Double
        get() = 0.0
        set(value) {}

    override var longitude: Double
        get() = 0.0
        set(value) {}

    override val view = View(context)
}