import React from 'react'
import { View, Text, StyleSheet, Dimensions, Image, TouchableOpacity } from "react-native"
import { NavigationContainer, createNavigationContainerRef } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { foodImagePath } from './FoodImagePath';
const navigationRef = createNavigationContainerRef()

function navigate(name, params) {
  if (navigationRef.isReady()) {
    navigationRef.navigate(name, params);
  }
}

const CarouselCardItem = ({ item, navigation, index}) => {
  return (
    <View style={styles.container} key={index}>
      <TouchableOpacity onPress={() => navigation.navigate("RecipePage",  { foodName: item })}>
        {foodImagePath[item] ?
        <Image
          source={foodImagePath[item]}
          style={styles.image}
        />
         :
        <Image  
          source={require("../../images/food/basic.jpg")}
          style={styles.image}
        />
        }
        <View style={styles.title}>
          <Text style={{fontSize: 20, fontWeight: "bold", color: "#fff",}}>{item}</Text>
        </View>
      </TouchableOpacity>
      {/* <Text style={styles.body}>{item.body}</Text> */}
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    marginTop: 20,
    backgroundColor: 'white',
    borderRadius: 8,
    width: Math.round(Dimensions.get('window').width * 0.5),
    shadowColor: "#000",
    shadowOffset: {
      width: 0,
      height: 3,
    },
    shadowOpacity: 0.29,
    shadowRadius: 4.65,
    elevation: 7,
    alignItems: 'center'
  },
  image: {
    width: Math.round(Dimensions.get('window').width * 0.5),
    height: 150,
    borderRadius: 8,
  },
  title: {
    position: 'absolute', 
    left: 10, 
    top: 20, 
    justifyContent: 'center', 
    alignItems: 'center'
  }
})

export default CarouselCardItem
