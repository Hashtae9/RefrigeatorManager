import { View, StyleSheet, Image, Text, TouchableOpacity } from 'react-native'
import React from 'react'
import { Avatar } from '@rneui/themed';
import { logoutUser } from '../../../_actions/user_action';
import { useDispatch } from 'react-redux';

const UserPage = ({username}) => {
  const dispatch = useDispatch();

  return (
    <View style={styles.mainviewStyle}>
      <View style={{flex: 1, flexDirection: 'row'}}>
        <Avatar
          size={70}
          rounded
          icon={{ name: 'user', type: 'font-awesome' }}
          containerStyle={styles.subViewStyle}
        />
        <View style={styles.subTextStyle}>
          <Text style={{fontSize: 25, fontFamily: 'SCDream5', color: "black",}}>{username}</Text>
          <Text>hello.</Text>
        </View>
      </View>
      <View
        style={{
          borderBottomColor: 'gray',
          borderBottomWidth: 1,
          paddingTop: 10,
          marginBottom:20,
          marginLeft: '9%',
          marginRight: '9%',
          marginTop: '3%'
        }}
      />
      <TouchableOpacity style ={{
        marginLeft: '9%',
        marginRight: '9%',
        marginTop: '3%',
        flexDirection: 'row'
      }} onPress={() => dispatch(logoutUser())}>
        <Text style={{fontSize: 15, fontFamily: 'SCDream3', color: "black",}}>logout</Text>
        <Text style={{fontSize: 18, fontFamily: 'SCDream5', color: "black",}}>></Text>
      </TouchableOpacity>
    </View>
  )
}
var styles = StyleSheet.create({
  mainviewStyle: {
    flex: 1,
    flexDirection: 'column',
    height: '100%'
  },
  subViewStyle: {
    backgroundColor: 'gray',
    marginLeft: '9%',
    marginRight: '6%',
    marginTop: '9%'
  },
  subTextStyle: {
    flex:1, 
    flexDirection: 'column',
    marginTop: '11%'
  }

}
);
export default UserPage