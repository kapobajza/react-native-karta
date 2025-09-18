import type {
  HybridView,
  HybridViewMethods,
  HybridViewProps,
} from 'react-native-nitro-modules'

export interface MapMarkerProps extends HybridViewProps {
  latitude: number
  longitude: number
}

export interface MapMarkerMethods extends HybridViewMethods {}

export type MapMarker = HybridView<
  MapMarkerProps,
  MapMarkerMethods,
  { ios: 'swift'; android: 'kotlin' }
>
