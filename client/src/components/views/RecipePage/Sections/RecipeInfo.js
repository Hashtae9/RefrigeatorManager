import { View, Text, ScrollView, StyleSheet } from 'react-native'
import React from 'react'
import { RecipeInfoData } from './RecipeInfoData'
const RecipeInfo = ({foodName}) => {
  return (
    <ScrollView style={styles.mainviewStyle}>
      <Text style={styles.titles}>{foodName}</Text>
      <Text style={styles.subTitles}>Ingredient</Text>
      <View
        style={{
          marginHorizontal: 10,
          borderBottomColor: 'black',
          borderBottomWidth: 2,
          paddingTop: 10
        }}
      />
      {RecipeInfoData[0].needs.map((need, index) => (
        <View key={index}>
          <Text style={styles.contents}>{need}</Text>
            <View
              style={{
                marginHorizontal:10,
                borderBottomColor: 'gray',
                borderBottomWidth: StyleSheet.hairlineWidth,
              }}
            />
        </View>
      ))}
      <Text style={styles.subTitles}>How to Cook</Text>
      <View
        style={{
          marginHorizontal: 10,
          borderBottomColor: 'black',
          borderBottomWidth: 2,
          paddingTop: 10
        }}
      />
      {RecipeInfoData[0].howTo.map((step, index) => (
        <View key={index}>
          <Text style={styles.contents}>{step}</Text>
            <View
              style={{
                marginHorizontal:10,
                borderBottomColor: 'gray',
                borderBottomWidth: StyleSheet.hairlineWidth,
              }}
            />
        </View>
      ))}
      <Text style={styles.subTitles}>Youtube Link</Text>
      <View
        style={{
          marginHorizontal: 10,
          borderBottomColor: 'black',
          borderBottomWidth: 2,
          paddingTop: 10
        }}
      />
      <Text style={styles.contents}>{RecipeInfoData[0].urlLink}</Text>
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
    fontSize: 50, 
    fontFamily: 'SCDream7',
    color: "black",
    paddingTop: 15,
    paddingLeft: 25,
  },
  subTitles: {
    fontSize: 25, 
    fontFamily: 'SCDream5',
    color: "black",
    paddingTop: 15,
    paddingLeft: 25
  },
  contents: {
    fontSize: 20, 
    fontFamily: 'SCDream2',
    color: "black",
    paddingTop: 15,
    paddingLeft: 25
  }
}
);
export default RecipeInfo