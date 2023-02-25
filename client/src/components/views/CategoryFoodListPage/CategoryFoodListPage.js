import { View, Text, ScrollView, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'

import SearchBar from '../Common/SearchBar'
import CanFood from './Sections/CanFood'
import AbleFood from './Sections/AbleFood'
import { useNavigation } from '@react-navigation/native';

const CategoryFoodListPage = ({route}) => {

  const navigation = useNavigation();
  return (
    <ScrollView style={styles.mainviewStyle}>
      <SearchBar/>
      <View style={styles.columText}>
        <Text style={styles.titles}>{route.params.category}</Text>
        <TouchableOpacity onPress={() =>navigation.navigate("CanFoodListPage",  { category: route.params.category })}>
          <Text style={styles.subtext}>more...    </Text>
        </TouchableOpacity>
      </View>
      <CanFood/>
      <View style={styles.columText}>
        <Text style={styles.titles}>{route.params.category}</Text>
        <TouchableOpacity onPress={() =>navigation.navigate("AbleFoodListPage",  { category: route.params.category })}>
          <Text style={styles.subtext}>more...    </Text>
        </TouchableOpacity>
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
export default CategoryFoodListPage