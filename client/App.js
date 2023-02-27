import 'react-native-gesture-handler';
import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Provider } from 'react-redux';

import RefrigeratorPage from './src/components/views/RefrigeratorPage/RefrigeratorPage';
import LoginPage from './src/components/views/LoginPage/LoginPage';
import LandingStack from './LandingStack';
import { applyMiddleware, createStore } from 'redux';
import promiseMiddleware from 'redux-promise';
import ReduxThunk from 'redux-thunk';
import Reducer from './src/_reducers'
const Tab = createBottomTabNavigator();
const createStoreWithMiddleware = applyMiddleware(promiseMiddleware, ReduxThunk)(createStore)

// const RootStack = createNativeStackNavigator();
export default function App() {
  return (
    <Provider 
    store = {createStoreWithMiddleware(Reducer)}
    >
      <NavigationContainer>
        <Tab.Navigator initialRouteName="Home">
          <Tab.Screen name="Refrigerator" component={RefrigeratorPage} options={{headerShown: false}}/>
          <Tab.Screen name="Home" component={LandingStack} options={{headerShown: false}}/>
          <Tab.Screen name="User" component={LoginPage} options={{headerShown: false}}/>
        </Tab.Navigator>
      </NavigationContainer>
    </Provider>
  );
}




