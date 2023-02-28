import { View, Text, ScrollView, StyleSheet, Image } from 'react-native'
import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { foodImagePath } from '../../Common/FoodImagePath'
const RecipeInfo = ({foodName}) => {
  
  useEffect(() => {
    const getURl = 'http://10.0.2.2:8080/recipes/api/detailRecipe/' + foodName;
      axios.get(getURl)
     .then(response => setFoodInfo(response.data))
     .catch(error => console.log(error))
  }, [])
  const [foodInfo, setFoodInfo] = useState([])
  return (
    <ScrollView style={styles.mainviewStyle} stickyHeaderIndices={[1]}>
      <Image
          source={foodImagePath[foodName]}
          style={styles.image}
      />
      {foodInfo && foodInfo.ingredients &&
      <View>
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
      {Object.values(foodInfo.ingredients).map((need, index) => (
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
      {foodInfo.rec_description.split("/n").map((step, index) => (
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
      <Text style={styles.contents}>{foodInfo.rec_link}</Text>
      </View>
      }
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
  },
  image: {
    height: 300,
    width: '100%',
    borderRadius: 8,
  }
}
);
export default RecipeInfo