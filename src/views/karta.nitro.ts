import type {
  HybridView,
  HybridViewProps,
  HybridViewMethods,
} from 'react-native-nitro-modules'

export interface KartaProps extends HybridViewProps {
   isRed: boolean
}

export interface KartaMethods extends HybridViewMethods {}

export type Karta = HybridView<KartaProps, KartaMethods, { ios: 'swift', android: 'kotlin' }>