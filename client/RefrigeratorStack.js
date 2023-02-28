import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import {createStackNavigator} from '@react-navigation/stack';
import RefrigeratorPage from './src/components/views/RefrigeratorPage/RefrigeratorPage';
import DeletePage from './src/components/views/DeletePage.js/DeletePage';
const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();
export default function RefrigeratorStack() {
    return (
      <Stack.Navigator>
          <Stack.Screen name="RefrigeratorPage" component={RefrigeratorPage} options={{headerShown: false}}/>
          <Stack.Screen name="DeletePage" component={DeletePage} options={{headerShown: false}}/>
      </Stack.Navigator>
    );
  }