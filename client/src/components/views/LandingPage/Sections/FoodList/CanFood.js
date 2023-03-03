import React, {useEffect, useState} from 'react'
import { View, Dimensions } from "react-native"
import Carousel, { Pagination } from 'react-native-snap-carousel'
import { useNavigation } from '@react-navigation/native';
import CanFoodData from './CanFoodData'
import CarouselCardItem from '../../../Common/CarouselCardItem'
import axios from 'axios';
import { useSelector } from 'react-redux';
import { useIsFocused } from '@react-navigation/native';
const CanFood = () => {
  const user = useSelector(state => state.user.loginSuccess);
  const isFocused = useIsFocused(); // isFoucesd Define
  const pagenum = Math.floor(Math.random() * 20);

  useEffect(() => {
    if (user) {
      const refri = user.refrigerator
      const getURl = 'http://10.0.2.2:8080/recipes/api/recommendRecipe/' + refri;
      axios.get(getURl)
     .then(response => setCanFoodList(response.data))
     .catch(error => console.log(error))
    } else {
      const getURl = 'http://10.0.2.2:8080/recipes/api/searchRecipe/' + pagenum;
      console.log(pagenum)
      axios.get(getURl)
     .then(response => setCanFoodList(response.data.content))
     .catch(error => console.log(error))
    }
  }, [isFocused])
  const [canFoodList, setCanFoodList] = useState([])
  const navigation = useNavigation();
  const SLIDER_WIDTH = Dimensions.get('window').width
  const ITEM_WIDTH = Math.round(SLIDER_WIDTH * 0.5)
  const [index, setIndex] = React.useState(0)
  const isCarousel = React.useRef(null)

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