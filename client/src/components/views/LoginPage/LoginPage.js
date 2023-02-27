import { View, Text, StyleSheet, TextInput, ScrollView, TouchableOpacity, Button } from 'react-native'
import React, { useState } from 'react'
import { Chip } from '@rneui/themed';
import axios from 'axios';
import { useNavigation } from '@react-navigation/native';
import { useDispatch } from 'react-redux';
import { loginUser } from '../../../_actions/user_action';
import UserPage from '../UserPage/UserPage';
import { useSelector } from 'react-redux';

const LoginPage = () => {
  const user = useSelector(state => state.user.loginSuccess);
  const navigation = useNavigation();
  const dispatch = useDispatch();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const onSubmitHandler = () => {
    // axios.post('http://10.0.2.2:8080/reacttest')
    //  .then(response => console.log(response.data))
    //  .catch(error => console.log(error))
    body = {
      "username": username,
      "password": password
    }
    
    dispatch(loginUser(body))
      .then(response => {
        if (response.payload) {
          navigation.navigate("LandingPage");
        }
      })

      // axios.post('http://10.0.2.2:8080/auth/login', body)
      // .then(response => console.log(response))
      // .catch(error => console.log(error))
    
  }
  return (
    <ScrollView>
      {/* <TouchableOpacity ><Button title="user" onPress={() =>{
        console.log(user)
        }}></Button></TouchableOpacity> */}
      {user?
      <UserPage username={user.username}/>
      :
      <View>
        <View style={styles.signInTextContainer}>
          <Text style={styles.signInText}>Login</Text>
          <Text style={styles.signInTextS}>Please Login for more services...</Text>
          <View
            style={{
              borderBottomColor: 'black',
              borderBottomWidth: 1,
              paddingTop: 10,
              marginBottom: 50,
            }}
          />
      </View>
      <TextInput
            value={username}
            onChangeText={(username) => setUsername(username)}
            placeholder={"Write You Email..."}
            style={styles.input}    
      />
      <TextInput
            value={password}
            onChangeText={(password) => setPassword(password)}
            placeholder={"Write You Password..."}
            style={styles.input}    
      />
      <Chip 
            title="Login"
            color="pink"
            titleStyle = {{ fontSize: 20, fontFamily: 'SCDream5' }}
            containerStyle={{marginVertical: 15, 
              marginHorizontal: 30}}
            onPress={onSubmitHandler}
      />
      <View
            style={{
              borderBottomColor: 'black',
              borderBottomWidth: 1,
              paddingTop: 10,
              marginBottom:20,
              marginLeft: '9%',
              marginRight: '9%'
            }}
          />
        <TouchableOpacity style = {{alignItems:'center'}}onPress={() =>navigation.navigate("RegisterPage")}>
          <Text style={styles.signInTextS}>회원가입</Text>

        </TouchableOpacity>
      </View>
      }
    </ScrollView>
  )
}


const styles = StyleSheet.create({
	signInTextContainer: {
        marginTop: '23%',
        marginLeft: '9%',
        marginRight: '9%'
    },
    signInText: {
        fontSize: 25,
        fontWeight: '500',
        color: 'black',
        lineHeight: 29.3,
    },
    signInTextS: {
        fontSize: 12,
        fontWeight: '300',
        color: 'balck',
        marginTop: 5,
    
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
    
 })
export default LoginPage