import { View, Text, ScrollView, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import CanFood from './Sections/CanFood'
import SearchBar from '../Common/SearchBar'
const CanFoodListPage = () => {
  return (
    <ScrollView style={styles.mainviewStyle}>
        <SearchBar/>
          <View style={styles.columText}>
            <Text style={styles.titles}>You Can Cook...</Text> 
          </View>
        <CanFood/>
    </ScrollView>
  )
}
var styles = StyleSheet.create({
    mainviewStyle: {
    flex: 1,
    flexDirection: 'column',
    height: '100%'
    },
    titles: {
      fontFamily: "SCDream7",
      fontSize: 20, 
      color: "black",
      paddingTop: 15,
      paddingLeft: 25
    },
    columText: {
      flex: 1,
      flexDirection: 'row',
      alignItems: 'center',
      justifyContent: 'space-between'
    },
    subtext: {
      fontFamily: "SCDream3",
      fontSize: 20, 
      color: "gray",
      paddingTop: 15,
      paddingLeft: 25
    }
  }
  );
export default CanFoodListPage