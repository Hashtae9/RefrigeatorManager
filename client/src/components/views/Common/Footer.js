// import { View, Text, StyleSheet, TouchableHighlight } from 'react-native'
// import React, { useState } from 'react'
// import { useNavigation } from '@react-navigation/native';

// const Footer = () => {
//   const [IsLogin, setIsLogin] = useState(false)
//   const navigation = useNavigation();
//   return (
//     <View style={styles.footer}>
//       <TouchableHighlight style={styles.bottomButtons} onPress={() =>navigation.navigate("RefrigeratorPage")}>
//           <Text style={styles.footerText}>Refrigerator</Text>
//       </TouchableHighlight>
//       <TouchableHighlight style={styles.bottomButtons} onPress={IsLogin?() =>navigation.navigate("LandingPage"):() =>navigation.navigate("LoginPage")}>
//           <Text style={styles.footerText}>{IsLogin? 'UserInfo' : 'Login' }</Text>
//       </TouchableHighlight>
//     </View>
//   )
// }

// var styles = StyleSheet.create({
// footer: {
//   backgroundColor:'gray',
//   flexDirection:'row',
//   flexWrap: 'wrap',
//   height:80,
//   position: 'absolute',
  
// },
// bottomButtons: {
//   alignItems:'center',
//   justifyContent: 'center',
//   flex:1,
// },
// footerText: {
//   color:'white',
//   fontWeight:'bold',
//   alignItems:'center',
//   fontSize:18,
// },
// textStyle: {
//   alignSelf: 'center',
//   color: 'orange'
// },
// scrollViewStyle: {
//   borderWidth: 2,
//   borderColor: 'blue'
// }
// });

// export default Footer