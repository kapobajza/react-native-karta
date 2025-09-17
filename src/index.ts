import { getHostComponent, type HybridRef } from 'react-native-nitro-modules'
import KartaConfig from '../nitrogen/generated/shared/json/KartaConfig.json'
import type {
  KartaProps,
  KartaMethods,
} from './views/karta.nitro'


export const Karta = getHostComponent<KartaProps, KartaMethods>(
  'Karta',
  () => KartaConfig
)

export type KartaRef = HybridRef<KartaProps, KartaMethods>
