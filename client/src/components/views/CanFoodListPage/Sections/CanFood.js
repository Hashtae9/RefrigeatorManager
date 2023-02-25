import React, {useEffect, useState} from 'react'
import { View, Dimensions } from "react-native"
import Carousel, { Pagination } from 'react-native-snap-carousel'
import { useNavigation } from '@react-navigation/native';
import CanFoodData from './CanFoodData'
import CarouselCardItem from '../../Common/CarouselCardItem'
import axios from 'axios';
import { useSelector } from 'react-redux';

const CanFood = () => {
  const user = useSelector(state => state.user.loginSuccess);
  useEffect(() => {
    if (user) {
      axios.get('http://10.0.2.2:8080/recipes/api/recommendRecipe')
     .then(response => setCanFoodList(response.data))
     .catch(error => console.log(error))
    } else {
      axios.get('http://10.0.2.2:8080/recipes/api/searchRecipe')
     .then(response => setCanFoodList(response.data))
     .catch(error => console.log(error))
    }
    console.log(canFoodList)
  }, [user])
  const [canFoodList, setCanFoodList] = useState([])
  const navigation = useNavigation();
  const [index, setIndex] = React.useState(0)
  const isCarousel = React.useRef(null)
  const SLIDER_WIDTH = Dimensions.get('window').width
  const ITEM_WIDTH = Math.round(SLIDER_WIDTH * 0.5)
  return (
    <View>
      <Carousel
        layout="default"
        ref={isCarousel}
        data={canFoodList}
        renderItem = {({item}) => {
          return <CarouselCardItem item={item} navigation={navigation}/>
        }}
        sliderWidth={SLIDER_WIDTH}
        itemWidth={ITEM_WIDTH}
        onSnapToItem={(index) => setIndex(index)}
        useScrollView={true}
      />
      <Pagination
        dotsLength={canFoodList.length}
        activeDotIndex={index}
        carouselRef={isCarousel}
        dotStyle={{
          width: 10,
          height: 10,
          borderRadius: 5,
          backgroundColor: 'rgba(0, 0, 0, 0.92)'
        }}
        inactiveDotOpacity={0.4}
        inactiveDotScale={0.6}
        tappableDots={true}
      />
    </View>
  )
}


export default CanFood