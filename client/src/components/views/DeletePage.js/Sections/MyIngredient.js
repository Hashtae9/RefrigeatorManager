import { View, Text, ScrollView, StyleSheet, TouchableOpacity, Image, Button, Dimensions } from 'react-native'
import React from 'react'
import { Chip } from '@rneui/themed';
import { BottomSheet } from '@rneui/themed';
import { useState } from 'react';
import { useNavigation } from '@react-navigation/native';
import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { imagePath } from '../../Common/ImagePath';
import axios from 'axios';


const MyIngredient = () => {
  const user = useSelector(state => state.user.loginSuccess);
  useEffect(() => {
    axios.get('http://10.0.2.2:8080/ingre_refri/api/ingreInRefri')
     .then(response => setmyIngredientData(response.data))
     .catch(error => console.log(error))
  }, [])

  const willDeleteToggle = (ingredient) => {
    const currentIndex = willDeleteIngredientList.indexOf(ingredient)
    const newList = [...willDeleteIngredientList]
    console.log(willDeleteIngredientList)
    if (currentIndex === -1){
      newList.push(ingredient)
    } else {
      newList.splice(currentIndex, 1)
    }
    setWillDeleteIngredientList(newList)
  }
  const [willDeleteIngredientList, setWillDeleteIngredientList] = useState([])
  const navigation = useNavigation();
  const [myIngredientData, setmyIngredientData] = useState([""])

  return (
    <View style = {styles.mainviewStyle}>
      <TouchableOpacity ><Button title="user" onPress={() =>{
        
        }}></Button></TouchableOpacity>

      <View style={{flexDirection:'row',
    alignItems: 'center',
    justifyContent: 'space-between'}}>
        <Text style={styles.subTitles}>Ingredient</Text>
      </View>
      <View
        style={{
          marginHorizontal: 10,
          borderBottomColor: 'black',
          borderBottomWidth: 2,
          paddingTop: 10
        }}
      />
      {myIngredientData[0] && 
      <View style={styles.columViewStyle}>
      {myIngredientData[0] && myIngredientData.map((ingredientData, index) => (
        <View style = {{ height:70, marginBottom:30, marginHorizontal:5 }} key={index} >
          <TouchableOpacity onPress={() => willDeleteToggle(ingredientData)} style={styles.innerView} >
            <Image
            source={imagePath[ingredientData.ingreName]}
            style={styles.image}
            />
            <Text style={styles.text}>{ingredientData.ingreName}</Text>
          </TouchableOpacity>
        </View>
      ))
      }
      </View>
      }
      
      {myIngredientData[0] && 
      <Chip 
        title="Delete"
        color="pink"
        titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
        containerStyle={ styles.chip }
      />}
      
    </View>
  )
}
var styles = StyleSheet.create({
  mainviewStyle: {
  flex: 1,
  flexDirection: 'column',
  height: '100%',
  },
  columViewStyle: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'flex-start',
    marginBottom: 15,
    marginTop: 15,
    marginHorizontal:40,
    maxWidth: Dimensions.get('window').width * 0.8,
    flexWrap: 'wrap',
    justifyContent: 'flex-start',
  },
  image: {
    width: 70,
    height: 70,
    borderRadius: 8,
    marginBottom: 5, 
  },
  imageOnclick: {
    width: 70,
    height: 70,
    borderRadius: 8,
    marginBottom: 5,  
    borderColor: 'red'
  },
  innerView: {
    flex: 1,
    alignItems: 'center',
    width: 70,
    height: 70,
    marginBottom: 20,
    marginTop: 15,
  },
  text: {
    fontFamily: "BMJUA_ttf",
  },
  subTitles: {
    flex: 3,
    fontSize: 25, 
    fontFamily: 'SCDream5',
    color: "black",
    paddingTop: 15,
    paddingLeft: 25
  },
  chip: {
    position: 'absolute',
    right: 0,
    left: 0,
    bottom: 60,
    marginVertical: 15, 
    marginHorizontal: 30
  },
  chipbelow: {
    position: 'absolute',
    right: 0,
    left: 0,
    bottom: 0,
    marginVertical: 15, 
    marginHorizontal: 30
  },
  contents: {
    fontSize: 20, 
    fontFamily: 'SCDream3',
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
    flex:1,
    fontFamily: "SCDream3",
    fontSize: 20, 
    color: "pink",
    paddingTop: 18,
    paddingLeft: 25,
  },
  subtextTwo: {
    flex:1,
    fontFamily: "SCDream3",
    fontSize: 20, 
    color: "pink",
    paddingTop: 15,
    paddingLeft: 25,
    paddingRight: 25
  }
}
);
export default MyIngredient