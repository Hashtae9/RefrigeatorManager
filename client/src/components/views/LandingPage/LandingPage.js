import { View, Text, ScrollView, StyleSheet, TouchableOpacity, Button } from 'react-native'
import React, { useState, useEffect }  from 'react'
import axios from 'axios';
import SearchBar from '../Common/SearchBar'
import FoodList from './Sections/FoodList'
import CategoryFood from './Sections/CategoryFood'
import { useSelector } from 'react-redux';

const LandingPage = () => {
  const user = useSelector(state => state.user.loginSuccess);
  return (
    <ScrollView style={styles.mainviewStyle}>
      <SearchBar />
      <FoodList />
      <View
        style={{
          marginHorizontal:10,
          borderBottomColor: 'gray',
          borderBottomWidth: StyleSheet.hairlineWidth,
        }}
      />

      {/* <CategoryFood /> */}
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
    fontSize: 20, 
    fontWeight: "bold", 
    color: "black",
    paddingTop: 15,
    paddingLeft: 25
  },
}
);
export default LandingPage