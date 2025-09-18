import React from 'react';
import { StyleSheet, View } from 'react-native';
import { MapMarker, MapView } from 'react-native-karta';

function App(): React.JSX.Element {
  return (
    <View style={styles.container}>
      <MapView
        zoom={17}
        style={styles.view}
        latitude={43.860535}
        longitude={18.3831301}
      >
        <MapMarker latitude={43.860535} longitude={18.3831301} />
        <MapMarker latitude={43.861} longitude={18.384} />
      </MapView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  view: {
    flex: 1,
    backgroundColor: 'rgba(16, 255, 239, 0.1)',
  },
  circle: {
    position: 'absolute',
    top: '50%',
    left: '50%',
    width: 20,
    height: 20,
    borderRadius: 10,
    backgroundColor: 'rgba(0, 122, 255, 0.7)',
  },
});

export default App;
