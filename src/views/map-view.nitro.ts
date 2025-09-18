import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

interface MapViewChildProps {
  latitude: number
  longitude: number
}

interface MapViewChildren {
  key: string | null
  props: MapViewChildProps
}

export interface MapViewProps extends HybridViewProps {
  latitude: number
  longitude: number
  zoom: number
  children?: MapViewChildren | MapViewChildren[]
}

export interface MapViewMethods extends HybridViewMethods {}

export type MapView = HybridView<
  MapViewProps,
  MapViewMethods,
  { ios: 'swift'; android: 'kotlin' }
>
