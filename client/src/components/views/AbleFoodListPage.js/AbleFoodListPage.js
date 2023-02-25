import { View, Text, ScrollView, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import AbleFood from './Sections/AbleFood'
import SearchBar from '../Common/SearchBar'
const AbleFoodListPage = () => {
  return (
    <ScrollView style={styles.mainviewStyle}>
        <SearchBar/>
          <View style={styles.columText}>
            <Text style={styles.titles}>Maybe You Can Cook...</Text>
          </View>
        <AbleFood/>
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
export default AbleFoodListPage