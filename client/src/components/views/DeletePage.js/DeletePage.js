import { View, Text, StyleSheet } from 'react-native'
import React from 'react'
import MyIngredient from './Sections/MyIngredient'
import { useSelector } from 'react-redux'

const DeletePage = () => {
  const user = useSelector(state => state.user.loginSuccess);
  return (
    <View style={styles.mainviewStyle}>
      {/* {user?
      <MyIngredient />
      :<LoginPage/>} */}
      <MyIngredient/>
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
export default DeletePage