import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import MapViewConfig from '../nitrogen/generated/shared/json/MapViewConfig.json'
import MapMarkerConfig from '../nitrogen/generated/shared/json/MapMarkerConfig.json'

import { type MapViewProps, type MapViewMethods } from './views/map-view.nitro'
import {
  type MapMarkerProps,
  type MapMarkerMethods,
} from './views/map-marker.nitro'

export const MapView = getHostComponent<MapViewProps, MapViewMethods>(
  'MapView',
  () => MapViewConfig
)

export type MapViewRef = HybridRef<MapViewProps, MapViewMethods>

export const MapMarker = getHostComponent<MapMarkerProps, MapMarkerMethods>(
  'MapMarker',
  () => MapMarkerConfig
)

export type MapMarkerRef = HybridRef<MapMarkerProps, MapMarkerMethods>
