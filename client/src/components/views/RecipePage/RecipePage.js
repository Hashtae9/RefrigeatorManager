import { View, Text, ScrollView, StyleSheet } from 'react-native'
import React from 'react'
import RecipeInfo from './Sections/RecipeInfo'

const RecipePage = ({route}) => {
  return (
    <ScrollView style={styles.mainviewStyle}>
      <RecipeInfo foodName={ route.params.foodName }/>
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
  }
}
);
export default RecipePage