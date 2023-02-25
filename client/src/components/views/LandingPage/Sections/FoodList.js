import { View, Text, ScrollView, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import CanFood from './FoodList/CanFood'
import AbleFood from './FoodList/AbleFood'
import { useNavigation } from '@react-navigation/native';

const FoodList = () => {
  const navigation = useNavigation();
  return (
    <ScrollView >
      <View style={styles.columText}>
        <Text style={styles.titles}>You Can Cook...</Text>
        <TouchableOpacity onPress={() =>navigation.navigate("CanFoodListPage")}>
          <Text style={styles.subtext}>more...    </Text>
        </TouchableOpacity>
      </View>
      <CanFood/>
      <View
        style={{
          marginHorizontal:10,
          borderBottomColor: 'gray',
          borderBottomWidth: StyleSheet.hairlineWidth,
        }}
      />
      <View style={styles.columText}>
        <Text style={styles.titles}>Maybe You Can Cook...</Text>
        <TouchableOpacity onPress={() =>navigation.navigate("AbleFoodListPage")}>
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
export default FoodList