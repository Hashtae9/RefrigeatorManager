import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import AbleFoodListPage from './src/components/views/AbleFoodListPage.js/AbleFoodListPage';
import CanFoodListPage from './src/components/views/CanFoodListPage/CanFoodListPage';
import CategoryFoodListPage from './src/components/views/CategoryFoodListPage/CategoryFoodListPage';
import LandingPage from './src/components/views/LandingPage/LandingPage';
import RegisterPage from './src/components/views/RegisterPage/RegisterPage';
import RecipePage from './src/components/views/RecipePage/RecipePage';
import SearchPage from './src/components/views/SearchPage/SearchPage';
import UserFoodListPage from './src/components/views/UserFoodListPage/UserFoodListPage';
import DeletePage from './src/components/views/DeletePage.js/DeletePage';
import {createStackNavigator} from '@react-navigation/stack';


const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();
export default function LandingStack() {
  return (
    <Stack.Navigator>
        <Stack.Screen name="LandingPage" component={LandingPage} options={{headerShown: false}}/>
        <Stack.Screen name="SearchPage" component={SearchPage} options={{headerShown: false}}/>
        <Stack.Screen name="CanFoodListPage" component={CanFoodListPage} options={{headerShown: false}}/>
        <Stack.Screen name="AbleFoodListPage" component={AbleFoodListPage} options={{headerShown: false}}/>
        <Stack.Screen name="CategoryFoodListPage" component={CategoryFoodListPage} options={{headerShown: false}}/>
        <Stack.Screen name="UserFoodListPage" component={UserFoodListPage} options={{headerShown: false}}/>
        <Stack.Screen name="RecipePage" component={RecipePage} options={{headerShown: false}}/>
        <Stack.Screen name="RegisterPage" component={RegisterPage} options={{headerShown: false}}/>      
        <Stack.Screen name="DeletePage" component={DeletePage} options={{headerShown: false}}/>  
    </Stack.Navigator>
  );
}