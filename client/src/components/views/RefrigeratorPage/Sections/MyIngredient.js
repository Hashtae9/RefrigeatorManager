import { View, Text, ScrollView, StyleSheet, TouchableOpacity, Image, Button, Dimensions, TextInput } from 'react-native'
import React from 'react'
import { Chip } from '@rneui/themed';
import { BottomSheet } from '@rneui/themed';
import { useState } from 'react';
import { useNavigation } from '@react-navigation/native';
import { ingredientData } from './IngredientData';
import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { imagePath } from '../../Common/ImagePath';
import axios from 'axios';
import { Overlay } from '@rneui/themed';
import { useIsFocused } from '@react-navigation/native';
const MyIngredient = () => {
  const isFocused = useIsFocused(); // isFoucesd Define
  const user = useSelector(state => state.user.loginSuccess);
  const refri = user.refrigerator
  useEffect(() => {
    const getURl = 'http://10.0.2.2:8080/ingre_refri/api/ingreInRefri/' + refri;
    axios.get(getURl)
     .then(response => setmyIngredientData(response.data))
     .catch(error => console.log(error))
  }, [isFocused])

  const setIsVisibleToggler = () => {
    setIsVisible(!isVisible)
  }
  const [expireDate, setExpireDate] = useState("")
  const [dateVisible, setDateVisible] = useState(false)
  const navigation = useNavigation();
  const [isVisible, setIsVisible] = useState(false)
  const [willAddIngredientList, setWillAddIngredient] = useState([])
  const [myIngredientData, setmyIngredientData] = useState([""])
  
  const rednerWillAdd = (ingredientDatas) => {
    let checkIngreData = []
    //console.log(myIngredientData)
    myIngredientData.map((ingre, index) => checkIngreData.push(ingre.ingreName))
    return ingredientDatas.map((ingredient, index) => {
      if (checkIngreData.includes(ingredient.ingreName)) {
        return 
      } else{
        return(
          <View style = {{ height:70, marginBottom:30, marginHorizontal:5 }} key={index} >
            <TouchableOpacity onPress={() => willAddToggle(ingredient)} style={styles.innerView} >
              <Image
              source={imagePath[ingredient.ingreName]}
              style={styles.image}
              />
              <Text style={styles.text}>{ingredient.ingreName}</Text>
            </TouchableOpacity>
          </View>
        )
      }
      
    }
    )
  }
  const willAddIngredientHandler = () => {
    const newList = [...myIngredientData, willAddIngredientList]
    
    body = {
        "refriInfo" : {
            "refriID" : refri
        } ,
        "ingreInfo" : willAddIngredientList,
        "IngreRefriInfo" : {
            "refriExpirDate" :expireDate,
            "frozen" : 1,
            "ingreSeq" : willAddIngredientList.ingreID,
            "refriID" : refri
        }
    }
    console.log(body)
    axios.post('http://10.0.2.2:8080/ingre_refri/api/addIngre', body)
     .then(response => response.data)
     .catch(error => console.log(error))
    setmyIngredientData(newList)
    setWillAddIngredient([])
    setIsVisible(false)
    setDateVisible(false)
    setExpireDate("")
  }
  const willAddToggle = (ingredient) => {
    setWillAddIngredient(ingredient)
    setDateVisible(true)
    // const currentIndex = willAddIngredientList.indexOf(ingredient)
    // const newList = [...willAddIngredientList]

    // if (currentIndex === -1){
    //   newList.push(ingredient)
    // } else {
    //   newList.splice(currentIndex, 1)
    // }
    // setWillAddIngredient(newList)
  }


  return (
    <View style = {styles.mainviewStyle}>
      {/* <TouchableOpacity ><Button title="user" onPress={() =>{
        //console.log(user)
        }}></Button></TouchableOpacity> */}

      <View style={{flexDirection:'row',
    alignItems: 'center',
    justifyContent: 'space-between'}}>
        <Text style={styles.subTitles}>Ingredient</Text>
        <TouchableOpacity onPress={()=>setIsVisible(true)}>
          <Text style={styles.subtext}>Add</Text>
        </TouchableOpacity>
        {myIngredientData && 
        <TouchableOpacity onPress={()=>navigation.navigate("DeletePage")}>
          <Text style={styles.subtextTwo}>Delete</Text>
        </TouchableOpacity>
        }
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
          <TouchableOpacity style={styles.innerView} >
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
        title="Able Recipes"
        color="pink"
        titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
        containerStyle={ styles.chip }
        onPress={() => navigation.navigate("CanFoodListPage")}
      />}
      {!myIngredientData[0] && 
        <View style={{ flex: 1, justifyContent: 'center', alignItems:'center' }}>
          <Image style={{ width: 150, height: 200 }}source={require("../../../images/fridge.png")}/>
          <Text style={styles.contents}>There's nothing in your refrigerator...</Text>
          <Chip 
            title="Add you Ingredients"
            color="pink"
            titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
            containerStyle={styles.chip}
            onPress={() => setIsVisible(true)}
          />
          <Chip 
            title="Add you Ingredients with Camera"
            color="pink"
            titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
            containerStyle={styles.chipbelow}
            onPress={() =>navigation.navigate("BarcodeScanner")}
          />
        </View>
      }
      <BottomSheet isVisible={isVisible} onBackdropPress={() => setIsVisible(false)}>
        <ScrollView style={{ backgroundColor:'white', height: 300, borderTopLeftRadius: 10, borderTopRightRadius: 10 }}>
        <View style={styles.columViewStyle}>
          {ingredientData[0] && isVisible && rednerWillAdd(ingredientData)
          
          }
          <Overlay isVisible={dateVisible} onBackdropPress={() => setDateVisible(false)}>
            <Text style={styles.textPrimary}>유통 기한을 입력하세요.</Text>
            <TextInput
              value={expireDate}
              onChangeText={(expireDate) => setExpireDate(expireDate)}
              placeholder={"YYYY-MM-DD"}
              style={styles.input}    
            />
            <Button
              title="확인"
              color="pink"
              onPress={ () => willAddIngredientHandler()}
            />
          </Overlay>
        </View>
        </ScrollView>
        <View style={{backgroundColor:'white'}}>
        {/* <Chip 
            title="Add you Ingredients"
            color="pink"
            titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
            containerStyle={{marginVertical: 15, 
              marginHorizontal: 30}}
            onPress={() => willAddIngredientHandler()}
          /> */}
        </View>
      </BottomSheet>
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
    paddingTop: 18,
    paddingLeft: 25,
    paddingRight: 25
  },
  textPrimary: {
    marginVertical: 20,
    fontFamily: "SCDream5",
    textAlign: 'center',
    fontSize: 20,
  },
  textSecondary: {
    marginBottom: 10,
    textAlign: 'center',
    fontSize: 17,
  },
  input: {
    backgroundColor: '#FFFFFF',
    width: '83%',
    height: 48,
    paddingLeft: 15,
    borderRadius: 5,
    marginBottom: 18,
    alignSelf: 'center',
  },
}
);
export default MyIngredient