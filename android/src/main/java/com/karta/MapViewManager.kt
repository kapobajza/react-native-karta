package com.karta


import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import com.facebook.react.uimanager.ReactStylesDiffMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.StateWrapper
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.margelo.nitro.karta.*
import com.margelo.nitro.karta.views.HybridMapViewStateUpdater

/**
 * Represents the React Native `ViewManager` for the "MapView" Nitro HybridView.
 */
class MapViewManager : ViewGroupManager<ViewGroup>() {
    private val views = hashMapOf<View, HybridMapView>()

    override fun getName(): String {
        return "MapView"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): ViewGroup {
        val hybridView = HybridMapView(reactContext)
        val view = hybridView.view
        views[view] = hybridView
        return view
    }

    override fun updateState(
        view: ViewGroup,
        props: ReactStylesDiffMap,
        stateWrapper: StateWrapper
    ): Any? {
        val hybridView =
            views[view] ?: throw Error("Couldn't find view $view in local views table!")

        // 1. Update each prop individually
        hybridView.beforeUpdate()
        HybridMapViewStateUpdater.updateViewProps(hybridView, stateWrapper)
        hybridView.afterUpdate()

        // 2. Continue in base View props
        return super.updateState(view, props, stateWrapper)
    }
}