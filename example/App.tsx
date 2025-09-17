import React from 'react';
import { View, StyleSheet } from 'react-native';
import { Karta } from 'react-native-karta';

function App(): React.JSX.Element {
  return (
    <View style={styles.container}>
        <Karta isRed={true} style={styles.view} testID="karta" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  view: {
    width: 200,
    height: 200
  }});

export default App;