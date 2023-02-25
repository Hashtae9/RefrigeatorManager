import { View, Text, StyleSheet, TextInput, ScrollView, Image } from 'react-native'
import React, { useState } from 'react'
import { Chip } from '@rneui/themed';
import axios from 'axios';
import { useNavigation } from '@react-navigation/native';


const RegisterPage = () => {
  const navigation = useNavigation();

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setemail] = useState('');
  const qs = require('qs')
  const onSubmitHandler = () => {
    console.log(username)
    console.log(password)
    axios.post('http://10.0.2.2:8080/registerUser', qs.stringify(
      {
        "username": username,
        "password": password,
        "email": email,
        "role": "USER"
      }
    )
      )
     .then(response => navigation.navigate("LandingPage"))
     .catch(error => console.log(error))
  }
  return (
    <ScrollView>
      <View style={styles.signInTextContainer}>
          <Text style={styles.signInText}>회원가입</Text>
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
            placeholder={"Write You Id..."}
            style={styles.input}    
      />
      <TextInput
            value={password}
            onChangeText={(password) => setPassword(password)}
            placeholder={"Write You Password..."}
            style={styles.input}    
      />
      <TextInput
            value={email}
            onChangeText={(email) => setemail(email)}
            placeholder={"Write You Email..."}
            style={styles.input}    
      />
      <Chip 
            title="Register"
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
              marginBottom: 50,
              marginLeft: '9%',
              marginRight: '9%'
            }}
          />
      
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
export default RegisterPage