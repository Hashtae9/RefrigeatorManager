import { View, Text, ScrollView, StyleSheet, Image, TouchableOpacity } from 'react-native'
import React from 'react'
import { firstColumCategory, secondColumCategory, thirdColumCategory } from './CategoryData'
import { useNavigation } from '@react-navigation/native';

const CategoryFood = () => {
  const navigation = useNavigation();
  return (
    <ScrollView >
      <View style={styles.columViewStyle}>
      {firstColumCategory.map((category, index) => (
        <View key={index} style={styles.innerView}>
          <TouchableOpacity style={styles.innerView} onPress={() =>navigation.navigate("CategoryFoodListPage", { category: category.title })}>
          <Image
            source={category.src}
            style={styles.image}
            />
            <Text style={styles.text}>{category.title}</Text>
          </TouchableOpacity>
        </View>
      ))}
      </View>
      <View style={styles.columViewStyle}>
      {secondColumCategory.map((category, index) => (
        <View key={index} style={styles.innerView}>
          <TouchableOpacity style={styles.innerView} onPress={() =>navigation.navigate("CategoryFoodListPage", { category: category.title })}>
            <Image
              source={category.src}
              style={styles.image}
              />
              <Text style={styles.text}>{category.title}</Text>
          </TouchableOpacity>
        </View>
      ))}
      </View>
      <View style={styles.columViewStyle}>
      {thirdColumCategory.map((category, index) => (
        <View key={index} >
          <TouchableOpacity style={styles.innerView} onPress={() =>navigation.navigate("CategoryFoodListPage", { category: category.title })}>
              <Image
                source={category.src}
                style={styles.image}
                />
                <Text style={styles.text}>{category.title}</Text>
          </TouchableOpacity>
        </View>
      ))}
      </View>
    </ScrollView>
  )
}

var styles = StyleSheet.create({
  mainviewStyle: {
  flex: 1,
  flexDirection: 'column',
  height: '100%'
  },
  columViewStyle: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around',
    marginBottom: 15,
    marginTop: 15
  },
  image: {
    width: 50,
    height: 50,
    borderRadius: 8,
    marginBottom: 5
  },
  innerView: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },
  text: {
    fontFamily: "BMJUA_ttf",
  }
}
);
export default CategoryFood