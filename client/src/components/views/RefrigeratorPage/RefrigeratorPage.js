import { View, Text, StyleSheet } from 'react-native'
import React from 'react'
import MyIngredient from './Sections/MyIngredient'
import { useSelector } from 'react-redux'
import LoginPage from '../LoginPage/LoginPage'

const RefrigeratorPage = () => {
  const user = useSelector(state => state.user.loginSuccess);
  return (
    <View style={styles.mainviewStyle}>
      {user?
      <MyIngredient />
      :<LoginPage/>}
    </View>
  )
}
var styles = StyleSheet.create({
  mainviewStyle: {
  flex: 1,
  flexDirection: 'column',
  height: '100%',
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
export default RefrigeratorPage